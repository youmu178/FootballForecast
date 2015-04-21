package com.youmu.lotterydrawresult.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sunloto.drawing.lotterydrawresult.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by youzh on 2015/2/1.
 */
public class StickyListAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    private LayoutInflater mInflater;
    private String[] gameKind;
    private String[] gameHead;
    private String[] gameHot;
    private List<Game> gameList = new ArrayList<Game>();

    public StickyListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        gameHead = context.getResources().getStringArray(R.array.game_head);

        gameKind = context.getResources().getStringArray(R.array.game_kind);
        gameHot = context.getResources().getStringArray(R.array.hot_kind);

        for (int i = 0; i < gameKind.length; i++) {
            Game game = new Game();
            game.setHead(gameHead[0]);
            game.setName(gameKind[i]);
            gameList.add(game);
        }

        for (int i = 0; i < gameHot.length; i++) {
            Game game = new Game();
            game.setHead(gameHead[1]);
            game.setName(gameHot[i]);
            gameList.add(game);
        }

    }

    @Override
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        HeadViewHolder headViewHolder;
        if (view == null) {
            view = mInflater.inflate(R.layout.sticky_header, null);
            headViewHolder = new HeadViewHolder(view);
            view.setTag(headViewHolder);
        } else {
            headViewHolder = (HeadViewHolder) view.getTag();
        }
        headViewHolder.mTextHeand.setText(gameList.get(i).getHead());
        return view;
    }


    @Override
    public long getHeaderId(int i) {
        return gameList.get(i).getHead().subSequence(0,3).charAt(0);
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_sticky_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mItemTextGame.setText(gameList.get(position).getName());
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'sticky_header.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Inmite Developers (http://inmite.github.io)
     */
    class ViewHolder {
        @InjectView(R.id.itemTextGame)
        TextView mItemTextGame;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    class HeadViewHolder {
        @InjectView(R.id.textHeand)
        TextView mTextHeand;

        HeadViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    public class Game {
        private String name;
        private String head;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }
    }

}
