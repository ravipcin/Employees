package com.example.employees.repository;

import android.content.Context;

import com.example.employees.AppConstants;
import com.example.employees.model.Employee;
import com.example.employees.model.Employees;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class EmployeeRepository {
    private static EmployeeRepository instance;

    private final Context context;

    private EmployeeRepository(Context context) {
        this.context = context;
    }

    public static EmployeeRepository getInstance(Context context) {
        if (instance == null) {
            synchronized (EmployeeRepository.class) {
                if (instance == null) {
                    instance = new EmployeeRepository(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public List<Employee> getEmployeeList() {
        String json = getJsonFromAsset();
        Gson gson = new Gson();
        Employees employees = gson.fromJson(json, Employees.class);
        return employees.getEmployeeList();
    }

    private String getJsonFromAsset() {
        String json;
        try {
            InputStream in = context.getAssets().open(AppConstants.EMP_DATA_JSON);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
