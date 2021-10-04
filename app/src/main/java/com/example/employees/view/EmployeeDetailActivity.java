package com.example.employees.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.employees.AppConstants;
import com.example.employees.base.BaseActivity;
import com.example.employees.databinding.ActivityEmployeeDetailBinding;
import com.example.employees.model.Employee;

public class EmployeeDetailActivity extends BaseActivity {
    private ActivityEmployeeDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Employee employee = intent.getParcelableExtra(AppConstants.INTENT_EXTRA_EMPLOYEE);
        binding.userId.setText(employee.getUserId());
        binding.jobTitle.setText(employee.getJobTitle());
        binding.fullName.setText(employee.getFullName());
        binding.empCode.setText(employee.getEmpCode());
        binding.region.setText(employee.getRegion());
        binding.phoneNumber.setText(employee.getPhoneNumber());
        binding.emailAddress.setText(employee.getEmailAddress());
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
