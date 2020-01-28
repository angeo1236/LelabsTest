package com.lelabs.testapplication.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.lelabs.testapplication.utils.ProgressBarHandler;

public abstract class BaseMethodsActivity extends AppCompatActivity {

    ProgressBarHandler progressDialog;
    private KProgressHUD hud;

    public void showProgress() {
        showProgress("Please wait");
    }

    public void showProgress(String text) {

        progressDialog = new ProgressBarHandler(this);
        progressDialog.show();

    }


    public void dismissProgress() {
        if (progressDialog != null)
            progressDialog.hide();

    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showSimpleAlert(String title, String message, DialogInterface.OnClickListener onClickListener) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle(title != null ? title : "Alert");

        alertDialog.setMessage(message);

        alertDialog.setPositiveButton("OK", (dialog, which) -> {
            if (onClickListener != null)
                onClickListener.onClick(dialog, which);
        });

        alertDialog.show();
    }
}
