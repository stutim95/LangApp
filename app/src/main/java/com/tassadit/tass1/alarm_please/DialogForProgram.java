package com.tassadit.tass1.alarm_please;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DialogForProgram extends DialogFragment {
    @SuppressLint("NewApi")
    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.displayDialog)
                .setPositiveButton(R.string.setnewAlarm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Dialog dialog  = (Dialog) dialogInterface;
                        Context context = dialog.getContext();
                        Intent i = new Intent (context , MainActivity.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


}

