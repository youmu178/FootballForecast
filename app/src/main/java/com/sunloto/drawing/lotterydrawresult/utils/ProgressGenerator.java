package com.sunloto.drawing.lotterydrawresult.utils;


import com.dd.processbutton.ProcessButton;

import android.os.Handler;

import java.util.Random;

/**
 * Created by youzh on 2015/2/5.
 */
public class ProgressGenerator {

    public interface OnCompleteListener {

        public void onComplete();
    }

    private OnCompleteListener mListener;
    private int mProgress;
    private ProcessButton button;
    Handler handler;

    public ProgressGenerator(OnCompleteListener listener) {
        mListener = listener;
    }

    public void start(ProcessButton button) {
        this.button = button;

        handler = new Handler();
        handler.postDelayed(runnable, generateDelay());
    }

    private Random random = new Random();

    private int generateDelay() {
        return random.nextInt(1000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mProgress += 10;
            button.setProgress(mProgress);
//                if (mProgress < 100) {
//                    handler.postDelayed(this, generateDelay());
//                } else {
//                    mListener.onComplete();
//                }
        }
    };

    public void stop () {
        button.setProgress(0);
        handler.removeCallbacks(runnable);
    }


}
