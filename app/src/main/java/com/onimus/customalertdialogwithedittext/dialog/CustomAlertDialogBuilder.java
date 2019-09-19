/*
 *
 *  * Created by Murillo Comino on 19/09/19 14:09
 *  * Github: github.com/MurilloComino
 *  * StackOverFlow: pt.stackoverflow.com/users/128573
 *  * Email: murillo_comino@hotmail.com
 *  *
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 19/09/19 13:49
 *
 */

package com.onimus.customalertdialogwithedittext.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.onimus.customalertdialogwithedittext.R;

public class CustomAlertDialogBuilder extends AlertDialog.Builder {
    public CustomAlertDialogBuilder(Context context) {
        super(context);
    }

    public AlertDialog.Builder customBuilder(View view, String title, String positiveButton, String negativeButton) {
        return new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setView(view)
                .setCancelable(false)
                .setPositiveButton(positiveButton, null)
                .setNegativeButton(negativeButton, (dialog, which) -> {
                    Toast.makeText(getContext(), getContext().getString(R.string.string_message_cancel), Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                });
    }
}
