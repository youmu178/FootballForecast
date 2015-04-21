package com.youmu.lotterydrawresult.utils;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by youzh on 2015/2/9.
 */
public class LayoutCommon {

    public static void showRercentLayout(LinearLayout mItemPercentLayout, TextView mItemRercentLeft, TextView mItemRercentMiddle, TextView mItemRercentRight, int draw, int awayWin, int homeWin) {
        ViewGroup.LayoutParams layoutParams = mItemPercentLayout.getLayoutParams();

        ViewGroup.LayoutParams leftLayoutParams = mItemRercentLeft.getLayoutParams();
        leftLayoutParams.width = (int) (layoutParams.width * (homeWin / 100.0));
        mItemRercentLeft.setLayoutParams(leftLayoutParams);
        mItemRercentLeft.setText(homeWin + "%");

        ViewGroup.LayoutParams middleLayoutParams = mItemRercentMiddle.getLayoutParams();
        middleLayoutParams.width = (int) (layoutParams.width * (draw / 100.0));
        mItemRercentMiddle.setLayoutParams(middleLayoutParams);
        mItemRercentMiddle.setText(draw + "%");

        ViewGroup.LayoutParams rightLayoutParams = mItemRercentRight.getLayoutParams();
        rightLayoutParams.width = (int) (layoutParams.width * (awayWin / 100.0));
        mItemRercentRight.setLayoutParams(rightLayoutParams);
        mItemRercentRight.setText(awayWin + "%");
    }
}
