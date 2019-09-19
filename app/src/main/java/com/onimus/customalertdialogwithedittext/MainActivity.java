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

package com.onimus.customalertdialogwithedittext;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.onimus.customalertdialogwithedittext.dialog.CustomAlertDialog;
import com.onimus.customalertdialogwithedittext.dialog.CustomAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alertClick(View view) {
        @SuppressLint("InflateParams")
        View rootView = getLayoutInflater().inflate(R.layout.dialog_main, null);
        EditText editText = rootView.findViewById(R.id.edittext);
        editText.setFocusable(true);

        AlertDialog.Builder builder = new CustomAlertDialogBuilder(this)
                .customBuilder(rootView, this.getString(R.string.string_title), this.getString(R.string.string_send), this.getString(R.string.string_cancel));

        CustomAlertDialog alertDialog = new CustomAlertDialog(this, editText, builder.create());

        alertDialog.customButtonPositive(R.color.colorPrimaryDark, 18)
                .customButtonNegative(R.color.colorAccent, 18);

        alertDialog.show();
    }
}
