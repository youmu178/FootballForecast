package com.youmu.lotterydrawresult;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by youzh on 2015/5/8.
 */
public class WelcomeActivity extends BaseActionBarActivity {

    @InjectView(R.id.shimmer_tv)
    ShimmerTextView shimmerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);

        final Shimmer shimmer = new Shimmer();

        shimmer.setRepeatCount(2).setDuration(800).setDirection(Shimmer.ANIMATION_DIRECTION_LTR).setAnimatorListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                shimmer.cancel();
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        }).start(shimmerTv);
    }
}
