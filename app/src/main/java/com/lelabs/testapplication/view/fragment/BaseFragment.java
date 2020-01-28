package com.lelabs.testapplication.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kaopiz.kprogresshud.KProgressHUD;

public class BaseFragment extends Fragment {


    private KProgressHUD hud;

    public void showProgress() {
        showProgress("Please wait");
    }

    public void showProgress(String text) {
        if (hud == null)
            hud = KProgressHUD.create(getActivity())
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(text)
                    .show();
        else {
            hud.setLabel(text).show();
        }
    }


    public void dismissProgress() {
        if (hud != null)
            hud.dismiss();
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void showSimpleAlert(String title, String message, DialogInterface.OnClickListener onClickListener) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

        // Setting Dialog Title
        alertDialog.setTitle(title != null ? title : "Alert");

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // On pressing Settings button
        alertDialog.setPositiveButton("OK", (dialog, which) -> {
            if (onClickListener != null)
                onClickListener.onClick(dialog, which);
        });

        // Showing Alert Message
        alertDialog.show();
    }

}