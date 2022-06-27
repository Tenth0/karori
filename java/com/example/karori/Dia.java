package com.example.karori;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class Dia extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("確認");
        builder.setMessage("最初の画面に戻ります。よろしいですか。");
        builder.setPositiveButton("はい",null);
        builder.setNegativeButton("いいえ" , null);
        builder.setPositiveButton("はい",new Listener());
        builder.setNegativeButton("いいえ" , new Listener());
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which){
            switch(which){
                case DialogInterface.BUTTON_POSITIVE:
                    Intent inte = new Intent(getContext(),MainActivity.class);
                    startActivity(inte);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    Toast.makeText(getContext(),"戻りません", Toast.LENGTH_SHORT).show();
            }
        }
    }
}