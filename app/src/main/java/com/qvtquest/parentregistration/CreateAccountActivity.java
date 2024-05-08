package com.qvtquest.parentregistration;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "UserPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        EditText lastNameEditText = findViewById(R.id.last_name_edittext);
        EditText firstNameEditText = findViewById(R.id.first_name_edittext);
        EditText userNameEditText = findViewById(R.id.user_name_edittext);
        EditText emailAddressEditText = findViewById(R.id.email_address_edittext);
        EditText phoneNumberEditText = findViewById(R.id.phone_number_edittext);
        EditText passwordEditText = findViewById(R.id.password_edittext);
        Switch pushNotificationSwitch = findViewById(R.id.push_notification_switch);
        Switch allowSmsSwitch = findViewById(R.id.allow_sms_switch);
        Switch allowCameraSwitch = findViewById(R.id.allow_camera_switch);
        Switch allowLocationSwitch = findViewById(R.id.allow_location_switch);
        Switch allowEmailSwitch = findViewById(R.id.allow_email_switch);
        Button submitButton = findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String lastName = lastNameEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString();
                String userName = userNameEditText.getText().toString();
                String emailAddress = emailAddressEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                boolean allowPushNotification = pushNotificationSwitch.isChecked();
                boolean allowSmsNotification = allowSmsSwitch.isChecked();
                boolean allowCameraAccess = allowCameraSwitch.isChecked();
                boolean allowLocationServices = allowLocationSwitch.isChecked();
                boolean allowEmailNotifications = allowEmailSwitch.isChecked();

                // Check if any field is empty
                if (lastName.isEmpty() || firstName.isEmpty() || userName.isEmpty() ||
                        emailAddress.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return; // Stop further processing if any field is empty
                }



                // Save user details in SharedPreferences
                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("lastName", lastName);
                editor.putString("firstName", firstName);
                editor.putString("userName", userName);
                editor.putString("emailAddress", emailAddress);
                editor.putString("phoneNumber", phoneNumber);
                editor.putString("password", password);
                editor.putBoolean("allowPushNotification", allowPushNotification);
                editor.putBoolean("allowSmsNotification", allowSmsNotification);
                editor.putBoolean("allowCameraAccess", allowCameraAccess);
                editor.putBoolean("allowLocationServices", allowLocationServices);
                editor.putBoolean("allowEmailNotifications", allowEmailNotifications);
                editor.apply();

                // Go back to previous screen
                finish();
            }
        });
    }
}
