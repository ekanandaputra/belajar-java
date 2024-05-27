/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author moladin
 */
public class RupiahConverter {

    public static String convertToRupiah(int amount) {
        return convertToRupiah(amount, false);
    }

    public static String convertToRupiah(int amount, boolean isUsingIdr) {
        DecimalFormat rupiahFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();

        if (isUsingIdr) {
            formatSymbols.setCurrencySymbol("IDR ");
        } else {
            formatSymbols.setCurrencySymbol("Rp ");
        }
        formatSymbols.setMonetaryDecimalSeparator(',');
        formatSymbols.setGroupingSeparator('.');

        rupiahFormat.setDecimalFormatSymbols(formatSymbols);

        return rupiahFormat.format(amount);
    }
}
