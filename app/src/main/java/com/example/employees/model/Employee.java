package com.example.employees.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Employee implements Parcelable {
    @SerializedName("userId")
    private String userId;
    @SerializedName("jobTitleName")
    private String jobTitle;
    @SerializedName("preferredFullName")
    private String fullName;
    @SerializedName("employeeCode")
    private String empCode;
    @SerializedName("region")
    private String region;
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("emailAddress")
    private String emailAddress;

    public Employee() {}

    public Employee(
            String userId,
            String jobTitle,
            String fullName,
            String empCode,
            String region,
            String phoneNumber,
            String emailAddress
    ) {
        this.userId = userId;
        this.jobTitle = jobTitle;
        this.fullName = fullName;
        this.empCode = empCode;
        this.region = region;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    protected Employee(Parcel in) {
        userId = in.readString();
        jobTitle = in.readString();
        fullName = in.readString();
        empCode = in.readString();
        region = in.readString();
        phoneNumber = in.readString();
        emailAddress = in.readString();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userId);
        dest.writeString(jobTitle);
        dest.writeString(fullName);
        dest.writeString(empCode);
        dest.writeString(region);
        dest.writeString(phoneNumber);
        dest.writeString(emailAddress);
    }
}
