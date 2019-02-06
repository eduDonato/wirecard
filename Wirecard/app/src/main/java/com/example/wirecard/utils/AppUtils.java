package com.example.wirecard.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.wirecard.ui.listener.OnClickDialogListener;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * App utils methods
 */
public class AppUtils {

    private static final int MIN_DIGITO_DIVISOR = 2;
    private static final int DEFAULT_MAX_DIGITO_DIVISOR = 2;

    /**
     * Format money asking its symbol, value to be converted and number of decimal cases
     * @param symbol
     * @param valor
     * @param number
     * @return
     */
    public static String formatMoney(String symbol, double valor, int number) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(valor));
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(MIN_DIGITO_DIVISOR);
        df.setMaximumFractionDigits(DEFAULT_MAX_DIGITO_DIVISOR);
        df.setDecimalFormatSymbols(symbols);
        return String.format("%s %s", symbol, df.format(bigDecimal.setScale(number, BigDecimal.ROUND_DOWN)));
    }

    /**
     * Format money asking its symbol and value to be converted
     * @param symbol
     * @param valor
     * @return
     */
    public static String formatMoney(String symbol, double valor) {
        return formatMoney(symbol, valor, 2);
    }

    /**
     * Convert date from an old pattern to a new pattern
     * @param oldPattern
     * @param newPattern
     * @param source
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String getData(String oldPattern, String newPattern, String source) {
        try {
            DateFormat f = new SimpleDateFormat(oldPattern);
            Date d = f.parse(source);
            DateFormat date = new SimpleDateFormat(newPattern);

            return date.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Method to show an OK dialog
     * @param message
     * @param con
     */
    public static void showCustomDialogOK(String message, Context con) {
        AlertDialog alertDialog = new AlertDialog.Builder(con).create();
        alertDialog.setTitle("Alerta");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    /**
     * Method to show a Yes/No dialog
     * @param message
     * @param con
     */
    public static void showCustomDialogYesNo(String message, Context con) {
        final OnClickDialogListener listener = (OnClickDialogListener) con;
        AlertDialog alertDialog = new AlertDialog.Builder(con).create();
        alertDialog.setTitle("Alerta");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogPositiveClick();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        listener.onDialogNegativeClick();
                    }
                });
        alertDialog.show();
    }
}
