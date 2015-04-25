package com.youmu.lotterydrawresult.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youmu.lotterydrawresult.R;
import com.youmu.lotterydrawresult.bean.HotGame;
import com.youmu.lotterydrawresult.utils.LayoutCommon;
import com.youmu.lotterydrawresult.utils.Utils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by youzh on 2015/2/3.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.RecyclerViewHolder> implements View.OnClickListener {
    private List<HotGame> gameList;
    private Context ctx;
    private RecyclerOnItemClickListener mOnItemClickListener = null;

    public MainRecyclerAdapter(Context ctx, List<HotGame> gameList) {
        this.ctx = ctx;
        this.gameList = gameList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_layout, viewGroup, false);
//        View layout = View.inflate(viewGroup.getContext(), R.layout.item_recycler_layout, null);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(layout);
        layout.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
        HotGame game = gameList.get(i);
        Long gameDate = game.getDate();// 比赛时间
        String leagueName = game.getLeagueName();//赛事级别
        String homeTeamName = game.getHomeTeamName();// 主队名
        String AwayTeamName = game.getAwayTeamName();// 客队名
        int homeGoal = game.getHomeGoal();// 主队预测分
        int awayGoal = game.getAwayGoal();// 客队预测分
        int homeWin = game.getHomeWin();// 胜概率
        int draw = game.getDraw();//平概率
        int awayWin = game.getAwayWin();// 负概率

        recyclerViewHolder.mItemGameDate.setText("比赛时间：" + Utils.getTimeStrFromMillis(gameDate));
        recyclerViewHolder.mItemGameLeague.setText(leagueName);
        recyclerViewHolder.mItemGameName.setText(homeTeamName + " " + homeGoal + "" + ":" + awayGoal + "" + " " + AwayTeamName);

        LayoutCommon.showRercentLayout(recyclerViewHolder.mItemPercentLayout, recyclerViewHolder.mItemRercentLeft, recyclerViewHolder.mItemRercentMiddle, recyclerViewHolder.mItemRercentRight, draw, awayWin, homeWin);

        recyclerViewHolder.mItemLayout.setTag(game);
    }


    @Override
    public int getItemCount() {
        return gameList.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.OnItemClickListener((HotGame) v.getTag());
        }
    }

    public void setOnItemClickListener(RecyclerOnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.itemLayout)
        LinearLayout mItemLayout;
        @InjectView(R.id.item_game_date)
        TextView mItemGameDate;
        @InjectView(R.id.item_game_league)
        TextView mItemGameLeague;
        @InjectView(R.id.item_game_name)
        TextView mItemGameName;
        @InjectView(R.id.percent_layout)
        LinearLayout mItemPercentLayout;
        @InjectView(R.id.percent_left_tv)
        TextView mItemRercentLeft;
        @InjectView(R.id.percent_middle_tv)
        TextView mItemRercentMiddle;
        @InjectView(R.id.percent_right_tv)
        TextView mItemRercentRight;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

    public interface RecyclerOnItemClickListener {
        void OnItemClickListener(HotGame game);
    }
}
