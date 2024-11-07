package com.linkitsoft.mrcodekiosk.Helper;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CommonUtils {
    public static String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }

    public static String getCurrentDate(){
        // Get the current date
        Calendar calendar = Calendar.getInstance();

        // Define the date format: "EEEE. d MMM, yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE. d MMM, yyyy", Locale.getDefault());

        // Format the current date
        String currentDate = dateFormat.format(calendar.getTime());

        return currentDate;
    }

    public static String updatedTime(){
        // Get the current time
        SimpleDateFormat sdf = new SimpleDateFormat("hh : mm a", Locale.getDefault());
        String currentTime = sdf.format(new Date());

        return currentTime;
    }

    public static String getTodayTime() {
        DateFormat df = new SimpleDateFormat("hh:mm a");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }

    public static double splitAmountDollar(TextView textView) {
        String text = textView.getText().toString();
        String number = text.replaceAll("[^\\d.]", "");
        System.out.println(number);

        return Double.parseDouble(number);
    }

    public static String padRight(String text, int totalWidth) {
        return String.format("%-" + totalWidth + "s", text);
    }


    public static String padLeft(String text, int totalWidth) {
        return String.format("%" + totalWidth + "s", text);
    }

    public static String getTodayDate() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }


    public static String getDateToday() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss aaa");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
    public static String repeat(String text, int length) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(text);
        }
        return sb.toString();
    }

    public static String getCurrentDay(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        String currentDay = dayFormat.format(calendar.getTime());
        return  currentDay.toLowerCase(Locale.ROOT);
    }

    public static String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String currentTime = timeFormat.format(calendar.getTime());
        return currentTime;
    }

    public static String formatDecimal(double value){
       return String.format("%.2f", value);
    }


    public static void appendToAmountText(String value, TextView textView) {
        // Get current text
        String currentText = textView.getText().toString();
        // Append the new value
        if (value.equals("C")){
            textView.setHint("0.00");
            textView.setText("");
        }else {
            textView.setText(currentText + value);
        }
    }


    public static void updatePinDisplay(Context context,String text, StringBuilder pinInput, TextView textView){
        // If you want to mask the PIN with '*', uncomment the following line:
        // String maskedPin = pinInput.toString().replaceAll(".", "*");

        // To show the actual digits:
        if (text.equals("C")) {
            // Remove last character if input is not empty
            if (pinInput.length() > 0) {
                pinInput.deleteCharAt(pinInput.length() - 1);
            }
        } else {
            // Append the clicked button's text to the input
            if (pinInput.length() < 6) {
                pinInput.append(text);
            } else {
//                UIHelper.showShortErrorToasty(context, "Max limit is 6 digits", false);
            }
        }

        textView.setText(pinInput.toString());
    }
//    public static void appendForPhoneNumber(Context context,String text, StringBuilder pinInput, TextView textView){
//        // If you want to mask the PIN with '*', uncomment the following line:
//        // String maskedPin = pinInput.toString().replaceAll(".", "*");
//
//        // To show the actual digits:
//        if (text.equals("C")) {
//            // Remove last character if input is not empty
//            if (pinInput.length() > 0) {
//                pinInput.deleteCharAt(pinInput.length() - 1);
//            }
//        } else {
//            // Append the clicked button's text to the input
//            if (pinInput.length() < 12) {
//                pinInput.append(text);
//            } else {
//                UIHelper.showShortErrorToasty(context, "Max limit is 12 digits", false);
//            }
//        }
//
//        textView.setText(pinInput.toString());
//    }


//    public static void appendForScanCode(Context context,String text, StringBuilder pinInput, TextView textView){
//
//        if (text.equals("C")) {
//            // Remove last character if input is not empty
//            if (pinInput.length() > 0) {
//                pinInput.deleteCharAt(pinInput.length() - 1);
//            }
//        } else {
//            // Append the clicked button's text to the input
//            if (pinInput.length() < 20) {
//                pinInput.append(text);
//            } else {
//                UIHelper.showShortErrorToasty(context, "Max limit is 20 digits", false);
//            }
//        }
//
//        textView.setText(pinInput.toString());
//    }

    public static void appendToPinText(String value,TextView textView) {
        // Get current text
        String currentText = textView.getText().toString();
        // Append the new value
        if (value.equals("C")){
            textView.setHint("PIN");
            textView.setText("");
        }else {
            textView.setText(currentText + value);
        }
    }
//    public static void appendToPinTextForLoyalty(String value,TextView textView) {
//        // Get current text
//        String currentText = textView.getText().toString();
//        // Append the new value
//        if (value.equals("C")){
//            textView.setHint("Enter Phone Number");
//            textView.setText("");
//        }else {
//            textView.setText(currentText + value);
//        }
//    }

    public static void appendToPinTextForVerifyAge(String value,TextView textView) {
        // Get current text
        String currentText = textView.getText().toString();
        // Append the new value
        if (value.equals("C")){
            textView.setHint("(MM DD YYYY)");
            textView.setText("");
        }else {
            textView.setText(currentText + value);
        }
    }
    public static void appendForQuantity(Context context,String text, StringBuilder pinInput, TextView textView){
        if (text.equals("C")) {
            if (pinInput.length() > 0) {
                pinInput.deleteCharAt(pinInput.length() - 1);
            }
        } else {
            if (pinInput.length() < 4) {
                pinInput.append(text);
            } else {
//                UIHelper.showShortErrorToasty(context, "Max limit is 12 digits", false);
            }
        }

        textView.setText(pinInput.toString());
    }

    public static void updateResult(TextView pinText,StringBuilder input) {
        try {

            // If input is not empty, treat it as a whole number
            if (input.length() > 0) {
                long amount = Long.parseLong(input.toString());

                // Treat input as cents, format the value as dollars with 2 decimal places
                double value = amount / 100.0;

                // Format the value with commas and 2 decimal places (ATM style)
                NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
                formatter.setMinimumFractionDigits(2);
                formatter.setMaximumFractionDigits(2);

                // Set formatted value in the TextView
                pinText.setText(formatter.format(value));
            } else {
                // Clear the result if the input is empty
                pinText.setText("");
            }
        } catch (NumberFormatException e) {
            // In case of invalid input, just show the raw input
            pinText.setText(input.toString());
        }
    }
    public static void updateResult(String text , TextView pinText, StringBuilder input) {
        try {
            if (text.equals("C")) {
                // Remove last character if input is not empty
                if (input.length() > 0) {
                    input.deleteCharAt(input.length() - 1);
                }
            }  else {
                // Append the clicked button's text to the input
                if (input.length() < 7) {
                    input.append(text);
                } else {
//                UIHelper.showShortErrorToasty(context, "Max limit is 6 digits", false);
                }
                // Append the clicked button's text to the input
//                input.append(text);
            }

            // If input is not empty, treat it as a whole number
            if (input.length() > 0) {
                // Convert input to a long, considering it as cents (removing decimal if exists)
                String processedInput = input.toString().replace(".", "");
                long amount = Long.parseLong(processedInput);

                // Treat input as cents, format the value as dollars with 2 decimal places
                double value = amount / 100.0;

                // Format the value with commas and 2 decimal places (ATM style)
                NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
                formatter.setMinimumFractionDigits(2);
                formatter.setMaximumFractionDigits(2);

                // Set formatted value in the TextView
                pinText.setText("$"+formatter.format(value));
            } else {
                // Clear the result if the input is empty
                pinText.setText("");
            }
        } catch (NumberFormatException e) {
            // In case of invalid input, just show the raw input
            pinText.setText(input.toString());
        }
    }
    public static void updatePercentageResult(String text , TextView pinText, StringBuilder input) {
        try {
            if (text.equals("C")) {
                // Remove last character if input is not empty
                if (input.length() > 0) {
                    input.deleteCharAt(input.length() - 1);
                }
            }  else {
                // Append the clicked button's text to the input
                if (input.length() < 7) {
                    input.append(text);
                } else {
//                UIHelper.showShortErrorToasty(context, "Max limit is 6 digits", false);
                }
                // Append the clicked button's text to the input
//                input.append(text);
            }

            // If input is not empty, treat it as a whole number
            if (input.length() > 0) {
                // Convert input to a long, considering it as cents (removing decimal if exists)
                String processedInput = input.toString().replace(".", "");
                long amount = Long.parseLong(processedInput);

                // Treat input as cents, format the value as dollars with 2 decimal places
                double value = amount / 100.0;

                // Format the value with commas and 2 decimal places (ATM style)
                NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
                formatter.setMinimumFractionDigits(2);
                formatter.setMaximumFractionDigits(2);

                // Set formatted value in the TextView
                pinText.setText("%"+formatter.format(value));
            } else {
                // Clear the result if the input is empty
                pinText.setText("");
            }
        } catch (NumberFormatException e) {
            // In case of invalid input, just show the raw input
            pinText.setText(input.toString());
        }
    }
    public static void updateBalance(String text , TextView pinText, TextView balanceText, StringBuilder input, double totalAmount, double amountCounter) {
        try {
            if (text.equals("C")) {
                // Remove last character if input is not empty
                if (input.length() > 0) {
                    input.deleteCharAt(input.length() - 1);
                }
            }  else {
                // Append the clicked button's text to the input
                input.append(text);
            }

            // If input is not empty, treat it as a whole number
            if (input.length() > 0) {
                // Convert input to a long, considering it as cents (removing decimal if exists)
                String processedInput = input.toString().replace(".", "");
                long amount = Long.parseLong(processedInput);

                // Treat input as cents, format the value as dollars with 2 decimal places
                double value = amount / 100.0;

                // Format the value with commas and 2 decimal places (ATM style)
                NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
                formatter.setMinimumFractionDigits(2);
                formatter.setMaximumFractionDigits(2);

                // Set formatted value in the TextView
                pinText.setText("$ "+formatter.format(value));
                if(amountCounter == 0){
                    balanceText.setText("$ "+formatter.format(totalAmount-value));
                }else {
                    balanceText.setText("$ "+formatter.format(totalAmount - (amountCounter + value)));
                }
            } else {
                // Clear the result if the input is empty
                pinText.setText("");
                balanceText.setText("$ "+ CommonUtils.formatDecimal((totalAmount - amountCounter)));
            }
        } catch (NumberFormatException e) {
            // In case of invalid input, just show the raw input
            pinText.setText(input.toString());
            balanceText.setText(input.toString());
        }
    }
    public static int hide_system_bars(View view) {
        return view.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | view.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | view.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | view.SYSTEM_UI_FLAG_FULLSCREEN
                | view.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    public static String removeDollarSign(String price) {
        if (price != null && price.startsWith("$")) {
            return price.substring(1); // Removes the first character ($)
        }
        return price; // Returns the original string if no $ symbol
    }

    public static String removeDollarSignAndCommas(String price) {
        if (price != null) {
            // Remove the dollar sign
            price = price.replace("$", "");

            // Remove commas
            price = price.replace(",", "");
        }
        return price; // Returns the modified string
    }
    public static String removePercentageSignAndCommas(String price) {
        if (price != null) {
            // Remove the dollar sign
            price = price.replace("%", "");

            // Remove commas
            price = price.replace(",", "");
        }
        return price; // Returns the modified string
    }


}
