package com.youmu.lotterydrawresult;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.extras.toolbar.MaterialMenuIconToolbar;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;
import com.youmu.lotterydrawresult.adapter.MainRecyclerAdapter;
import com.youmu.lotterydrawresult.adapter.StickyListAdapter;
import com.youmu.lotterydrawresult.bean.HotGame;
import com.youmu.lotterydrawresult.bean.User;
import com.youmu.lotterydrawresult.common.WebDefine;
import com.youmu.lotterydrawresult.net.BackCookie;
import com.youmu.lotterydrawresult.net.Net;
import com.youmu.lotterydrawresult.widget.DragLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;
import retrofit.client.Response;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends BaseActionBarActivity implements AdapterView.OnItemClickListener, View.OnClickListener, MainRecyclerAdapter.RecyclerOnItemClickListener {

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
    @InjectView(R.id.main_login)
    TextView mTVLogin;
    private MainRecyclerAdapter mainRecyclerAdapter;
    private List<HotGame> mGameLists = new ArrayList<HotGame>();
    private MaterialMenuIconToolbar materialMenu;

    private int clickPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        MobclickAgent.updateOnlineConfig(this);
        UmengUpdateAgent.update(this);

        initViews();
        getData(64);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(User user) {
        if (user != null) {
            mTVLogin.setText(" Hi, " + user.getUsername());
            SharedPreferences userConfig = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor edit = userConfig.edit();
            edit.putString("username", user.getUsername());
            edit.putString("password", user.getPassword());
            edit.commit();
        }
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
        mainRecyclerAdapter.setOnItemClickListener(this);

        SharedPreferences userConfig = PreferenceManager.getDefaultSharedPreferences(this);
        String username = userConfig.getString("username", "");
        if (!TextUtils.isEmpty(username)) {
            mTVLogin.setText(" Hi, " + username);
        }
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
//        if (id == R.id.action_share) {
//            return true;
//        } else
        if (id == R.id.action_explain) {
            showDialog("使用说明", getResources().getString(R.string.string_use), "取消", "", id);
            return true;
        } else if (id == R.id.action_website) {
            showDialog("官网", getResources().getString(R.string.string_web), "访问", "取消", id);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mDragLayout.close();
        getData(position);
    }

    private void getData(final int position) {
        mProgressLayout.setVisibility(View.VISIBLE);
        if (position < 63) {
            String[] gameKind = getResources().getStringArray(R.array.game_kind);
            mToolBar.setTitle(gameKind[position]);
            Net.getApi(WebDefine.URL).getLottertGameList((position + 1) + "", new BackCookie<List<HotGame>>() {
                        @Override
                        public void success(List<HotGame> hotGames, Response response) {
                            super.success(hotGames, response);
                            if (hotGames != null && !hotGames.isEmpty()) {
                                mGameLists.clear();
                                long nowDate = System.currentTimeMillis();
                                for (HotGame hotGame : hotGames) {
                                    Long date = hotGame.getDate();
                                    if (date > nowDate) {
                                        mGameLists.add(hotGame);
                                    }
                                }
                                clickPosition = position;
                                mProgressLayout.setVisibility(View.GONE);
                                mLayoutEmpty.setVisibility(View.GONE);
                                mainRecyclerAdapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            super.failure(error);
                            if (clickPosition != position) {
                                mGameLists.clear();
                                mainRecyclerAdapter.notifyDataSetChanged();
                            }
                            mProgressLayout.setVisibility(View.GONE);
                            mLayoutEmpty.setVisibility(View.VISIBLE);
                        }
                    }

            );
        } else {
            mToolBar.setTitle("热门预测");
            Net.getApi(WebDefine.URL).getLotteryHotList(new BackCookie<List<HotGame>>() {
                @Override
                public void success(List<HotGame> hotGames, Response response) {
                    super.success(hotGames, response);

                    if (hotGames != null && !hotGames.isEmpty()) {
                        mGameLists.clear();
                        long nowDate = System.currentTimeMillis();
                        for (HotGame hotGame : hotGames) {
                            Long date = hotGame.getDate();
                            if (date > nowDate) {
                                mGameLists.add(hotGame);
                            }
                        }
                        clickPosition = position;
                        mProgressLayout.setVisibility(View.GONE);
                        mLayoutEmpty.setVisibility(View.GONE);
                        mainRecyclerAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    super.failure(error);
                    if (clickPosition != position) {
                        mGameLists.clear();
                        mainRecyclerAdapter.notifyDataSetChanged();
                    }
                    mProgressLayout.setVisibility(View.GONE);
                    mLayoutEmpty.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    @OnClick({R.id.loging_layout})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loging_layout:
                startActivity(new Intent(this, LogingActivity.class));
                break;
        }
    }

    @Override
    public void OnItemClickListener(HotGame game) {
       if (game != null) {
           Intent intent = new Intent(mAct, ForecastDetailActivity.class);
           intent.putExtra("gameID", game.getId()+"");
           startActivity(intent);
       }
    }
}
