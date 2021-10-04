package com.example.employees.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.employees.base.BaseViewModel;
import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;

import java.util.List;

public class HomeViewModel extends BaseViewModel {
    private final MutableLiveData<List<Employee>> employeeList = new MutableLiveData<>();

    public HomeViewModel(Context context) {
        EmployeeRepository repository = EmployeeRepository.getInstance(context);
        employeeList.postValue(repository.getEmployeeList());
    }

    public LiveData<List<Employee>> getEmployeeList() {
        return employeeList;
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final Context context;

        public Factory(Context context) {
            this.context = context;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new HomeViewModel(context);
        }
    }
}
