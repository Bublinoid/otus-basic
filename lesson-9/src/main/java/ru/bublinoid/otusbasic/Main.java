package ru.bublinoid.otusbasic;

import ru.bublinoid.otusbasic.entity.Employee;
import ru.bublinoid.otusbasic.service.EmployeeService;
import ru.bublinoid.otusbasic.utils.ListUpdate;
import ru.bublinoid.otusbasic.utils.SequentialValuesGenerator;
import ru.bublinoid.otusbasic.utils.SumOfNumbers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> sequentialValues = SequentialValuesGenerator.generateSequentialValues(1, 10);
        System.out.println("Последовательные значения: " + sequentialValues);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Otus1", 20));
        employees.add(new Employee("Otus2", 25));
        employees.add(new Employee("Otus3", 30));
        employees.add(new Employee("Otus4", 35));

        int sumGreaterFive = SumOfNumbers.sumGreaterThanFive(sequentialValues);
        System.out.println("Сумма значений больше 5: " + sumGreaterFive);

        ListUpdate.zoomListElement(5, sequentialValues);
        System.out.println("Обновленный список:" + sequentialValues);

        ListUpdate.zoomListElement(5, sequentialValues);
        System.out.println("Увеличенный список:" + sequentialValues);

        List<String> employeeName = EmployeeService.getEmployeeName(employees);
        System.out.println("Имена сотрудников: " + employeeName);

/*
Будет выводиться @hashcode имен сотрудников
        int minAge = 24;
        List<Employee> filtersEmployees = EmployeeOperations.filtersEmployeesByAge(employees, minAge);
        System.out.println("Отфильтрованные сотрудники по возрасту кому больше " + minAge + ": " + filtersEmployees);
*/
        int minAge = 24;
        List<Employee> filtersEmployees = EmployeeService.filtersEmployeesByAge(employees, minAge);
        System.out.print("Отфильтрованные сотрудники по возрасту кому больше " + minAge + ": ");
        for (Employee employee : filtersEmployees) {
            System.out.print(employee.name + ", ");
        }
        System.out.println();

        int thresholdAge = 27;
        boolean isAverageAgeGreater = EmployeeService.isAverageAgeGreater(employees, thresholdAge);
        System.out.println("Средний возраст больше, чем: " + thresholdAge + " " + isAverageAgeGreater);

        Employee youngestEmployee = EmployeeService.findYoungestEmployee(employees);
        System.out.println("Самый молодой сотрудник: " + (youngestEmployee != null ? youngestEmployee.name
                + " которому " + youngestEmployee.age + " лет" : "Нет сотрудников"));

    }
}