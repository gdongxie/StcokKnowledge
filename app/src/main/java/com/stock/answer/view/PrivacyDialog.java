package com.stock.answer.view;

import android.app.Dialog;
import android.content.Context;

import com.stock.answer.R;

public class PrivacyDialog extends Dialog {

    public PrivacyDialog(Context context) {
        super(context, R.style.PrivacyThemeDialog);
        setContentView(R.layout.dialog_privacy);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}
