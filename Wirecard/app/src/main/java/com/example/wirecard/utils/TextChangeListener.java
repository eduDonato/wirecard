package com.example.wirecard.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextChangeListener {

    public static TextWatcher getListener(final EditText a){
        return new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s)  {
                if (a.getText().toString().length() <= 0) {
                    a.setError("Não pode ser vazio");
                } else {
                    a.setError(null);
                }
            }
        };
    }
}
