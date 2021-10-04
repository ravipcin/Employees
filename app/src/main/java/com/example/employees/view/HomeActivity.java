package com.example.employees.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.employees.AppConstants;
import com.example.employees.adapter.EmployeeListAdapter;
import com.example.employees.base.BaseActivity;
import com.example.employees.databinding.ActivityHomeBinding;
import com.example.employees.model.Employee;
import com.example.employees.viewmodel.HomeViewModel;

public class HomeActivity extends BaseActivity {
    private ActivityHomeBinding binding;
    private HomeViewModel viewModel;
    private EmployeeListAdapter empListAdapter;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initViewModel();
        observeView();
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.empList.setLayoutManager(layoutManager);
        binding.empList.setHasFixedSize(true);
        empListAdapter = new EmployeeListAdapter(employee -> {
            this.employee = employee;
            navigateToEmployeeDetailsView();
        });
        binding.empList.setAdapter(empListAdapter);
    }

    private void initViewModel() {
        HomeViewModel.Factory factory = new HomeViewModel.Factory(getApplicationContext());
        viewModel = new ViewModelProvider(this, factory).get(HomeViewModel.class);
    }

    private void observeView() {
        viewModel.getEmployeeList().observe(this, employeeList -> {
            empListAdapter.updateDataset(employeeList);
            binding.progressBar.setVisibility(View.GONE);
        });
    }

    private void navigateToEmployeeDetailsView() {
        Intent intent = new Intent(this, EmployeeDetailActivity.class);
        intent.putExtra(AppConstants.INTENT_EXTRA_EMPLOYEE, employee);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        binding = null;
        viewModel = null;
        empListAdapter = null;
        employee = null;
        super.onDestroy();
    }
}