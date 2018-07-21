package id.or.codelabs.belajarbraille;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class ThemeSwitcherDialog extends DialogFragment{
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private String mValue;
    private boolean mValueSet;
    SharedPreferences prefs;
    private int mClickedDialogEntryIndex;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEntries = getResources().getStringArray(R.array.themes);
        mEntryValues = getResources().getStringArray(R.array.themes);
        mValue = prefs.getString("lang", "id");
    }

    @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Pilih Warna Tema Aplikasi");
        dialog.setPositiveButton(null, null);
        mClickedDialogEntryIndex = getValueIndex();
        dialog.setSingleChoiceItems(mEntries, mClickedDialogEntryIndex, selectItemListener);
        return dialog.create();
    }

    private int getValueIndex() {
        return findIndexOfValue(mValue);
    }

    public int findIndexOfValue(String value) {
        if (value != null && mEntryValues != null) {
            for (int i = mEntryValues.length - 1; i >= 0; i--) {
                if (mEntryValues[i].equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    DialogInterface.OnClickListener selectItemListener = new DialogInterface.OnClickListener() {

        @Override public void onClick(DialogInterface dialog, int which) {
            if (mClickedDialogEntryIndex != which) {
                mClickedDialogEntryIndex = which;
                mValue = mEntryValues[mClickedDialogEntryIndex].toString();
                prefs.edit().putString("lang", mValue).commit();
                if (mValue == "Tema Default"){
                    Utility.setTheme(getContext() , "Tema Default");
                } else if(mValue == "Tema Google"){
                    Utility.setTheme(getContext() , "Tema Google");
                }
            }
            dialog.dismiss();
        }
    };
}
