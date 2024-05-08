package com.qvtquest.parentregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "UserPrefs";
    public static final String PREF_LOGGED_IN = "loggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean(PREF_LOGGED_IN, false);
        if (isLoggedIn) {
            startActivity(new Intent(MainActivity.this, ParentProfile.class));
            finish(); // Finish the MainActivity to prevent returning to it when pressing back
        }

        EditText usernameEditText = findViewById(R.id.username_edittext);
        EditText passwordEditText = findViewById(R.id.password_edittext);
        Button loginButton = findViewById(R.id.login_button);
        Button createAccountButton = findViewById(R.id.create_account_button);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your login logic here
                // For demonstration purposes, assume login is successful if username and password are not empty
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    // If login is successful, set the logged-in status in SharedPreferences
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(PREF_LOGGED_IN, true);
                    editor.apply();

                    startActivity(new Intent(MainActivity.this, ParentProfile.class));
                    finish(); // Finish the MainActivity to prevent returning to it when pressing back
                } else {
                    // Display a toast message indicating that username and password cannot be empty
                    Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
