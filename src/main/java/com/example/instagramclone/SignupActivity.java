package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = "SignupActivity";
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view){
                ParseUser user = new ParseUser();
                user.setEmail(etEmail.getText().toString());
                user.setUsername(etUsername.getText().toString());
                user.setPassword(etPassword.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e != null) {
                            Log.e(TAG, "Error signing up!", e);
                            Toast.makeText(SignupActivity.this, "Error signing up!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Log.i(TAG, "Sign up successfull!");
                        goLoginActivity();
                    }
                });
            }
        });
    }

    private void goLoginActivity() {
        Toast.makeText(SignupActivity.this, "Successfully signed up!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(SignupActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
