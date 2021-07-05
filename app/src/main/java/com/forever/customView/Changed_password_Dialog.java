package com.forever.customView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.forever.R;

public class Changed_password_Dialog extends Dialog {


    public RelativeLayout reset_rl;


    public Changed_password_Dialog(@NonNull Context context) {
        super(context);
    }

    public Changed_password_Dialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected Changed_password_Dialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.changes_password_dialog_layout);

        reset_rl=findViewById(R.id.reset_rl);


    }
}
