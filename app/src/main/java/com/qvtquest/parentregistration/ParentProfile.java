package com.qvtquest.parentregistration;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ParentProfile extends AppCompatActivity {

    public static final String PREFS_NAME = "UserPrefs";

    private EditText lastNameEditText;
    private EditText firstNameEditText;
    private EditText userNameEditText;
    private EditText emailAddressEditText;
    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private Switch pushNotificationSwitch;
    private Switch allowSmsSwitch;
    private Switch allowCameraSwitch;
    private Switch allowLocationSwitch;
    private Switch allowEmailSwitch;
    private Button editButton;
    private Button saveButton;
    private Button cancelButton;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_profile);

        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        lastNameEditText = findViewById(R.id.last_name_edittext);
        firstNameEditText = findViewById(R.id.first_name_edittext);
        userNameEditText = findViewById(R.id.user_name_edittext);
        emailAddressEditText = findViewById(R.id.email_address_edittext);
        phoneNumberEditText = findViewById(R.id.phone_number_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        pushNotificationSwitch = findViewById(R.id.push_notification_switch);
        allowSmsSwitch = findViewById(R.id.allow_sms_switch);
        allowCameraSwitch = findViewById(R.id.allow_camera_switch);
        allowLocationSwitch = findViewById(R.id.allow_location_switch);
        allowEmailSwitch = findViewById(R.id.allow_email_switch);
        editButton = findViewById(R.id.edit_button);
        saveButton = findViewById(R.id.save_button);
        cancelButton = findViewById(R.id.cancel_button);

        // Populate EditText fields and switches with saved user data
        lastNameEditText.setText(preferences.getString("lastName", ""));
        firstNameEditText.setText(preferences.getString("firstName", ""));
        userNameEditText.setText(preferences.getString("userName", ""));
        emailAddressEditText.setText(preferences.getString("emailAddress", ""));
        phoneNumberEditText.setText(preferences.getString("phoneNumber", ""));
        passwordEditText.setText(preferences.getString("password", ""));
        pushNotificationSwitch.setChecked(preferences.getBoolean("allowPushNotification", false));
        allowSmsSwitch.setChecked(preferences.getBoolean("allowSmsNotification", false));
        allowCameraSwitch.setChecked(preferences.getBoolean("allowCameraAccess", false));
        allowLocationSwitch.setChecked(preferences.getBoolean("allowLocationServices", false));
        allowEmailSwitch.setChecked(preferences.getBoolean("allowEmailNotifications", false));

        // Initially, EditText fields and switches are not editable
        setEditable(false);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditable(true);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("lastName", lastNameEditText.getText().toString());
                editor.putString("firstName", firstNameEditText.getText().toString());
                editor.putString("userName", userNameEditText.getText().toString());
                editor.putString("emailAddress", emailAddressEditText.getText().toString());
                editor.putString("phoneNumber", phoneNumberEditText.getText().toString());
                editor.putString("password", passwordEditText.getText().toString());
                editor.putBoolean("allowPushNotification", pushNotificationSwitch.isChecked());
                editor.putBoolean("allowSmsNotification", allowSmsSwitch.isChecked());
                editor.putBoolean("allowCameraAccess", allowCameraSwitch.isChecked());
                editor.putBoolean("allowLocationServices", allowLocationSwitch.isChecked());
                editor.putBoolean("allowEmailNotifications", allowEmailSwitch.isChecked());
                editor.apply();
                setEditable(false);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restore original values
                lastNameEditText.setText(preferences.getString("lastName", ""));
                firstNameEditText.setText(preferences.getString("firstName", ""));
                userNameEditText.setText(preferences.getString("userName", ""));
                emailAddressEditText.setText(preferences.getString("emailAddress", ""));
                phoneNumberEditText.setText(preferences.getString("phoneNumber", ""));
                passwordEditText.setText(preferences.getString("password", ""));
                pushNotificationSwitch.setChecked(preferences.getBoolean("allowPushNotification", false));
                allowSmsSwitch.setChecked(preferences.getBoolean("allowSmsNotification", false));
                allowCameraSwitch.setChecked(preferences.getBoolean("allowCameraAccess", false));
                allowLocationSwitch.setChecked(preferences.getBoolean("allowLocationServices", false));
                allowEmailSwitch.setChecked(preferences.getBoolean("allowEmailNotifications", false));
                setEditable(false);
                Toast.makeText(ParentProfile.this, "No changes made", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setEditable(boolean editable) {
        lastNameEditText.setEnabled(editable);
        firstNameEditText.setEnabled(editable);
        userNameEditText.setEnabled(editable);
        emailAddressEditText.setEnabled(editable);
        phoneNumberEditText.setEnabled(editable);
        passwordEditText.setEnabled(editable);
        pushNotificationSwitch.setEnabled(editable);
        allowSmsSwitch.setEnabled(editable);
        allowCameraSwitch.setEnabled(editable);
        allowLocationSwitch.setEnabled(editable);
        allowEmailSwitch.setEnabled(editable);
        saveButton.setVisibility(editable ? View.VISIBLE : View.GONE);
        cancelButton.setVisibility(editable ? View.VISIBLE : View.GONE);
        editButton.setVisibility(editable ? View.GONE : View.VISIBLE);
    }
}
