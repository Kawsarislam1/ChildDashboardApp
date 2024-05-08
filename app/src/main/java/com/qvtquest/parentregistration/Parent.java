package com.qvtquest.parentregistration;

public class Parent {
    private String lastName;
    private String firstName;
    private String userName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private boolean allowPushNotification;
    private boolean allowSMSMessages;

    public Parent(String lastName, String firstName, String userName, String emailAddress, String password, String phoneNumber, boolean allowPushNotification, boolean allowSMSMessages, boolean allowCameraAccess, boolean allowLocationServices, boolean allowEmailNotification) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.allowPushNotification = allowPushNotification;
        this.allowSMSMessages = allowSMSMessages;
        this.allowCameraAccess = allowCameraAccess;
        this.allowLocationServices = allowLocationServices;
        this.allowEmailNotification = allowEmailNotification;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAllowPushNotification() {
        return allowPushNotification;
    }

    public void setAllowPushNotification(boolean allowPushNotification) {
        this.allowPushNotification = allowPushNotification;
    }

    public boolean isAllowSMSMessages() {
        return allowSMSMessages;
    }

    public void setAllowSMSMessages(boolean allowSMSMessages) {
        this.allowSMSMessages = allowSMSMessages;
    }

    public boolean isAllowCameraAccess() {
        return allowCameraAccess;
    }

    public void setAllowCameraAccess(boolean allowCameraAccess) {
        this.allowCameraAccess = allowCameraAccess;
    }

    public boolean isAllowLocationServices() {
        return allowLocationServices;
    }

    public void setAllowLocationServices(boolean allowLocationServices) {
        this.allowLocationServices = allowLocationServices;
    }

    public boolean isAllowEmailNotification() {
        return allowEmailNotification;
    }

    public void setAllowEmailNotification(boolean allowEmailNotification) {
        this.allowEmailNotification = allowEmailNotification;
    }

    private boolean allowCameraAccess;
    private boolean allowLocationServices;
    private boolean allowEmailNotification;

    // Constructor, getters, and setters
}
