package com.sunloto.drawing.lotterydrawresult.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.sunloto.drawing.lotterydrawresult.R;

public class DialogProgress extends DialogFragment {

    private Dialog dialog;

    public static DialogProgress newIntance() {
        DialogProgress dialog = new DialogProgress();
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(getActivity(), R.style.pro_dialog);
        View view = View.inflate(getActivity(), R.layout.dialog_progress, null);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(view);
        return dialog;
    }
}