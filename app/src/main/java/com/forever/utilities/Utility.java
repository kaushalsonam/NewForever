package com.forever.utilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;


import com.forever.BuildConfig;
import com.forever.R;
import com.forever.activities.MainActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

public class Utility {
    private static final String TAG = Utility.class.getSimpleName();
    private static Handler handler = new Handler();
    private static final long DELAY = 1500; // milliseconds
    private Context context;

    public static ProgressDialog loading_dialog;








    //hide Keyboard
    public static void hideKeyboard(Activity activity) {
        if (activity == null)
            return;
        try {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputManager != null && activity.getCurrentFocus() != null)
                inputManager.hideSoftInputFromInputMethod(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Utility.log("KeyBoardUtil >>> " + e);
        }
    }

    public static void hideKeyboard(View v) {
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }


    //log with value
    public static void log(String value) {
        if (BuildConfig.DEBUG) {
//            log(TAG, value);
            // logFile(value);
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }



    public static boolean isValidMail(String email) {

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(EMAIL_STRING).matcher(email).matches();

    }

    public static boolean isValidMobile(String phone) {
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() > 6 && phone.length() <= 13;
        }
        return false;
    }


    public static void showLoader() {
        if (loading_dialog != null) {
            loading_dialog.dismiss();
            loading_dialog = null;
        }
        if (loading_dialog == null) {
            loading_dialog = new ProgressDialog(MainActivity.context,R.style.MyAlertDialogStyle);
            loading_dialog.setMessage("Please Wait...");
            loading_dialog.show();
            loading_dialog.setCancelable(false);
        }
    }


    public static void hideLoader() {
        if (loading_dialog != null) {
            if (loading_dialog.isShowing())
                loading_dialog.dismiss();
        }

    }

    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }


    public static CircularProgressDrawable getCircleProgress(){
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(MainActivity.context);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(20f);
        circularProgressDrawable.setColorFilter(ContextCompat.getColor(MainActivity.context, R.color.dotcolor), PorterDuff.Mode.SRC_IN);
        circularProgressDrawable.start();
        return circularProgressDrawable;

    }

    public static void showKeyboard(Activity context) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }


    public static boolean isNetworkAvailable(final Context context, boolean showToast) {
        if (context == null)
            return false;
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        if (showToast) {
            new Handler(context.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "Please check your connection and try again.", Toast.LENGTH_LONG).show();
                }
            });
        }
        return false;
    }

}
