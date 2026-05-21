package com.learning.grpc.store;

import com.learning.grpc.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeStore {
    private static Map<Integer, Employee> employees = new HashMap<>();

    public void loadEmployees() {
        employees.put(1, new Employee(1, "John", 28, 80000));
        employees.put(2, new Employee(2, "Jane", 35, 120000));
        employees.put(3, new Employee(3, "Rahul", 20, 30000));
        employees.put(4, new Employee(4, "Jenifer", 25, 50000));
        employees.put(5, new Employee(5, "Pablo", 23, 40000));
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }
}
