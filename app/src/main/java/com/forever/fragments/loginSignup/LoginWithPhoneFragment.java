package com.forever.fragments.loginSignup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.forever.Model.ExistsPhoneEmailModel;
import com.forever.Model.LoginModel;
import com.forever.R;
import com.forever.ViewModel.EmailExistsViewModel;
import com.forever.ViewModel.LoginViewModel;
import com.forever.ViewModel.PhoneExsistViewModel;
import com.forever.ViewModel.PhoneSignupViewModel;
import com.forever.activities.HomeActivity;
import com.forever.activities.LoginActivity;
import com.forever.activities.MainActivity;
import com.forever.fragments.home.HomeFragment;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.forever.utilities.PrefrenceShared;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.gson.JsonObject;
import com.hbb20.CountryCodePicker;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


public class LoginWithPhoneFragment extends Fragment implements View.OnClickListener, TextWatcher, Observer<LoginModel> {

    private static final String TAG = "Login";
    private static final int RC_SIGN_IN = 234;
    private EditText mobile_num, et_password;
    private TextView login_btn;
    private LinearLayout reset_ll, txt_create_one_ll;
    private CountryCodePicker countryCodePicker;
    private ImageView fb_login, google_login;
    private LoginViewModel loginViewModel;
    private ImageView hide_password;
    private PhoneExsistViewModel phoneExsistViewModel;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth firebaseAuth;
    private Boolean loginFlag=false;
    private CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        viewModelSetup();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_with_phone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        mobile_num = view.findViewById(R.id.mobile_num);
        et_password = view.findViewById(R.id.et_password);
        login_btn = view.findViewById(R.id.login_btn);
        reset_ll = view.findViewById(R.id.reset_ll);
        txt_create_one_ll = view.findViewById(R.id.txt_create_one_ll);
        countryCodePicker = view.findViewById(R.id.countryCodePicker);
        fb_login = view.findViewById(R.id.fb_login);
        google_login = view.findViewById(R.id.google_login);
        hide_password = view.findViewById(R.id.hide_password);

        FacebookSdk.sdkInitialize(getActivity());
        callbackManager = CallbackManager.Factory.create();


        facbookLogin();


        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        firebaseAuth=FirebaseAuth.getInstance();

    }

    private void viewSetup() {

        login_btn.setOnClickListener(this);
        reset_ll.setOnClickListener(this);
        txt_create_one_ll.setOnClickListener(this);
        fb_login.setOnClickListener(this);
        google_login.setOnClickListener(this);
        hide_password.setOnClickListener(this);

        mobile_num.addTextChangedListener(this);

    }


    private void viewModelSetup() {

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.login.observe(this, this);

        phoneExsistViewModel = new ViewModelProvider(this).get(PhoneExsistViewModel.class);
        phoneExsistViewModel.phoneExists.observe(this, phoneExistsObserver);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.login_btn:

                if (!mobile_num.getText().toString().isEmpty()) {

                    if (!et_password.getText().toString().isEmpty()) {


                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(Constant.password, et_password.getText().toString());
                        jsonObject.addProperty(Constant.device_token, R.string.tocken);
                        jsonObject.addProperty(Constant.device_type, R.string.device_type);
                        jsonObject.addProperty(Constant.phone_code, countryCodePicker.getSelectedCountryCode());
                        jsonObject.addProperty(Constant.phone_number, mobile_num.getText().toString());


                        loginViewModel.userLogin(getActivity(), jsonObject);


                    }

                } else {

                    Toast.makeText(getActivity(), "Please enter valid data", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.reset_ll:

                ((LoginActivity) getActivity()).replaceFragment(new ResetPasswordFragment(), true,
                        KeyClass.FRAGMENT_RESET_PASSWORD, KeyClass.FRAGMENT_RESET_PASSWORD);

                break;

            case R.id.txt_create_one_ll:

                ((LoginActivity) getActivity()).replaceFragment(new SignupFragment(), false,
                        KeyClass.FRAGMENT_SIGNUP, KeyClass.FRAGMENT_SIGNUP);

                break;

            case R.id.fb_login:

//                facbookLogin();

                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile,email"));


                break;

            case R.id.google_login:

                signIn();

                break;

            case R.id.hide_password:

                if (et_password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {

                    et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                } else {

                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }

                break;


        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if (mobile_num.getText().toString().length() > 9) {

            JsonObject jsonObject= new JsonObject();
            jsonObject.addProperty(Constant.phone_number,mobile_num.getText().toString());
            jsonObject.addProperty(Constant.phone_code,countryCodePicker.getSelectedCountryCode());

            phoneExsistViewModel.exsistPhone(getActivity(),jsonObject);
            
        }

    }

    @Override
    public void onChanged(LoginModel loginModel) {

        loginFlag=true;

        PrefrenceShared.getInstance().getPreferenceData().setValue(Constant.loginflag, String.valueOf(loginFlag));

        Intent intent = new Intent(getActivity(), HomeActivity.class);
        ((LoginActivity) getActivity()).startActivity(intent);
        ((LoginActivity) getActivity()).finish();


    }

    private final Observer<ExistsPhoneEmailModel> phoneExistsObserver = new Observer<ExistsPhoneEmailModel>() {
        @Override
        public void onChanged(ExistsPhoneEmailModel existsPhoneEmailModel) {

            if(existsPhoneEmailModel.getExists().equals(true)){

                Toast.makeText(getActivity(), "This Contact number exist", Toast.LENGTH_SHORT).show();

            }

        }
    };


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());

            } catch (Exception e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }


        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data);


    }



    private void firebaseAuthWithGoogle(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
//                            updateUI(user);

//                            Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();

//                            ((LoginActivity)getActivity()).replaceFragment(new HomeFragment(),false,
//                                    KeyClass.FRAGMENT_HOME,KeyClass.FRAGMENT_HOME);

                            Intent intent= new Intent(getActivity(),HomeActivity.class);
                            startActivity(intent);
                            getActivity().finish();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            updateUI(null);

                            Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();

                            Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
//                            updateUI(user);
                            Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();

                            Intent intent= new Intent(getActivity(),HomeActivity.class);
                            startActivity(intent);
                            getActivity().finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


    public void facbookLogin(){

//        LoginManager.getInstance().logInWithReadPermissions(getActivity(), Arrays.asList("email","public_profile"));

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code

                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });


    }


}