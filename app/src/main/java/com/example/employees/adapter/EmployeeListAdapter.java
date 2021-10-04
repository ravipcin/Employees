package com.example.employees.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employees.databinding.EmployeeListItemBinding;
import com.example.employees.model.Employee;

import java.util.List;

public class EmployeeListAdapter extends
        RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {
    private List<Employee> employeeList;
    private final OnEmployeeListItemClickListener listener;

    public EmployeeListAdapter(OnEmployeeListItemClickListener listener) {
        this.listener = listener;
    }

    public EmployeeListAdapter(
            List<Employee> employeeList,
            OnEmployeeListItemClickListener listener
    ) {
        this.employeeList = employeeList;
        this.listener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateDataset(List<Employee> employeeList) {
        this.employeeList = employeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeListItemBinding binding = EmployeeListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.binding.empName.setText(employee.getFullName());
    }

    @Override
    public int getItemCount() {
        return employeeList != null ? employeeList.size() : 0;
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private final EmployeeListItemBinding binding;

        public EmployeeViewHolder(EmployeeListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            initViewHolder();
        }

        private void initViewHolder() {
            binding.empName.setOnClickListener(v -> {
                if (listener != null) {
                    Employee employee = employeeList.get(getBindingAdapterPosition());
                    listener.onClick(employee);
                }
            });
        }
    }

    public interface OnEmployeeListItemClickListener {
        void onClick(Employee employee);
    }
}
