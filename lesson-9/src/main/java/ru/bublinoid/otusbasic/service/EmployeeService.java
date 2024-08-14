package ru.bublinoid.otusbasic.service;

import ru.bublinoid.otusbasic.entity.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {

    public static List<String> getEmployeeName (List<Employee> employees) {
        return employees.stream()
                .map(employee -> employee.name)
                .collect(Collectors.toList());
    }

    public static List<Employee> filtersEmployeesByAge(List<Employee> employees, int minAge) {
        return employees.stream()
                .filter(employee -> employee.age >= minAge)
                .collect(Collectors.toList()); //Java 8 vs toList()
    }

    public static boolean isAverageAgeGreater(List<Employee> employees, int threshold) {
        double averageAge = employees.stream()
                .mapToDouble(employee -> employee.age)
                .average()
                .orElse(0);

        return averageAge > threshold;
    }

    public static Employee findYoungestEmployee(List<Employee> employees) {
        Optional<Employee> youngest = employees.stream()
                .min(Comparator.comparingInt(a -> a.age));
        return youngest.orElse(null);
    }
}