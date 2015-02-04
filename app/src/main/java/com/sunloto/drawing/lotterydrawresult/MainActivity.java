package com.sunloto.drawing.lotterydrawresult;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.extras.toolbar.MaterialMenuIconToolbar;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.sunloto.drawing.lotterydrawresult.adapter.MainRecyclerAdapter;
import com.sunloto.drawing.lotterydrawresult.adapter.StickyListAdapter;
import com.sunloto.drawing.lotterydrawresult.bean.HotGame;
import com.sunloto.drawing.lotterydrawresult.bean.Result;
import com.sunloto.drawing.lotterydrawresult.common.WebDefine;
import com.sunloto.drawing.lotterydrawresult.net.WoZhongLaApi;
import com.sunloto.drawing.lotterydrawresult.widget.DragLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    @InjectView(R.id.dragLayout)
    DragLayout mDragLayout;
    @InjectView(R.id.expandListView)
    ExpandableStickyListHeadersListView mExpandListView;
    @InjectView(R.id.tool_bar)
    Toolbar mToolBar;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @InjectView(R.id.progress_wheel)
    ProgressWheel mProgressLayout;
    @InjectView(R.id.empty_layout)
    TextView mLayoutEmpty;
    private MainRecyclerAdapter mainRecyclerAdapter;
    private List<HotGame> mGameLists = new ArrayList<HotGame>();
    private MaterialMenuIconToolbar materialMenu;
    private int actionBarMenuState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initViews();
        getData(64);
    }

    private void initViews() {
        mToolBar.setTitle("热门预测");
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDragLayout.isOpen()) {
                    materialMenu.animatePressedState(MaterialMenuDrawable.IconState.BURGER);
                    mDragLayout.close();
                } else {
                    materialMenu.animatePressedState(MaterialMenuDrawable.IconState.ARROW);
                    mDragLayout.open();
                }
            }
        });
        materialMenu = new MaterialMenuIconToolbar(this, Color.WHITE, MaterialMenuDrawable.Stroke.THIN) {
            @Override
            public int getToolbarViewId() {
                return R.id.tool_bar;
            }
        };
        materialMenu.setNeverDrawTouch(true);
        mDragLayout.setDragListener(new DragLayout.DragListener() {
            @Override
            public void onOpen() {
                materialMenu.animatePressedState(MaterialMenuDrawable.IconState.ARROW);
            }

            @Override
            public void onClose() {
                materialMenu.animatePressedState(MaterialMenuDrawable.IconState.BURGER);
            }

            @Override
            public void onDrag(float percent) {
//                ViewHelper.setAlpha();
            }
        });
        mExpandListView.setAdapter(new StickyListAdapter(this));
        mExpandListView.setOnHeaderClickListener(new StickyListHeadersListView.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(StickyListHeadersListView stickyListHeadersListView, View view, int itemPosition, long headerId, boolean currentlySticky) {
                if (mExpandListView.isHeaderCollapsed(headerId)) {
                    mExpandListView.expand(headerId);
                } else {
                    mExpandListView.collapse(headerId);
                }
            }
        });
        mExpandListView.setOnItemClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, mGameLists);
        mRecyclerView.setAdapter(mainRecyclerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("youzh", "位置： " + position);
        mDragLayout.close();
        getData(position);
    }

    private void getData(int position) {
        mProgressLayout.setVisibility(View.VISIBLE);
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(WebDefine.BASE_URL).build();
        WoZhongLaApi woZhongLaApi = restAdapter.create(WoZhongLaApi.class);
        if (position < 63) {
            woZhongLaApi.getLottertGameList((position + 1) + "", new Callback<List<HotGame>>() {
                @Override
                public void success(List<HotGame> hotGames, Response response) {
                    if (hotGames != null && !hotGames.isEmpty()) {
                        mGameLists.clear();
                        for (HotGame hotGame : hotGames) {
                            Long date = hotGame.getDate();

                            mGameLists.add(hotGame);
                        }
                        mProgressLayout.setVisibility(View.GONE);
                        mainRecyclerAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    mProgressLayout.setVisibility(View.GONE);
                    mLayoutEmpty.setVisibility(View.VISIBLE);
                }
            });
        } else {
            woZhongLaApi.getLotteryHotList(new Callback<List<HotGame>>() {
                @Override
                public void success(List<HotGame> hotGames, Response response) {
                    if (hotGames != null && !hotGames.isEmpty()) {
                        mGameLists.clear();
                        for (HotGame hotGame : hotGames) {
                            mGameLists.add(hotGame);
                        }
                        mProgressLayout.setVisibility(View.GONE);
                        mainRecyclerAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    mProgressLayout.setVisibility(View.GONE);
                    mLayoutEmpty.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
