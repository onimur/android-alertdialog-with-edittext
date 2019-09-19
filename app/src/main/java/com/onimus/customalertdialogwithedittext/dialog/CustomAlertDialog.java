/*
 *
 *  * Created by Murillo Comino on 19/09/19 14:09
 *  * Github: github.com/MurilloComino
 *  * StackOverFlow: pt.stackoverflow.com/users/128573
 *  * Email: murillo_comino@hotmail.com
 *  *
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 19/09/19 14:04
 *
 */

package com.onimus.customalertdialogwithedittext.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.onimus.customalertdialogwithedittext.R;

import java.util.Optional;

public class CustomAlertDialog extends AlertDialog {
    private EditText editText;
    private AlertDialog alertDialog;
    private int colorPositive;
    private int textSizePositive;
    private int colorNegative;
    private int textSizeNegative;


    public CustomAlertDialog(Context context, EditText editText, AlertDialog alertDialog) {
        super(context);
        this.editText = editText;
        this.alertDialog = alertDialog;
    }

    public CustomAlertDialog customButtonPositive(int colorResources, int textSize) {
        this.colorPositive = colorResources;
        this.textSizePositive = textSize;
        return this;
    }

    public CustomAlertDialog customButtonNegative(int colorResources, int textSize) {
        this.colorNegative = colorResources;
        this.textSizeNegative = textSize;
        return this;
    }

    public void show() {
        alertDialog.setOnShowListener(showListener());
        alertDialog.show();
    }

    private OnShowListener showListener() {
        return dialog -> {
            Button positive = alertDialog.getButton(BUTTON_POSITIVE);
            Optional<Integer> positiveColor = Optional.of(colorPositive);
            positiveColor
                    .ifPresent(c -> {
                        positive.setTextColor(ContextCompat.getColor(getContext(), c));
                        positive.setTextSize(textSizePositive);
                    });

            Optional<Integer> negativeColor = Optional.of(colorNegative);

            negativeColor
                    .ifPresent(c -> {
                        Button negative = alertDialog.getButton(BUTTON_NEGATIVE);
                        negative.setTextColor(ContextCompat.getColor(getContext(), c));
                        negative.setTextSize(textSizeNegative);
                    });
            positive.setOnClickListener(clickListener(dialog));
        };
    }

    private View.OnClickListener clickListener(DialogInterface dialog) {
        return v -> {
            // here you treat the event
            if (editText.getText().length() == 0) {
                editText.setError(getContext().getString(R.string.string_field));
                editText.setFocusable(true);
                editText.requestFocus();
            } else {
                //your action
                Toast.makeText(getContext(), getContext().getString(R.string.toast_sent), Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        };
    }
}


