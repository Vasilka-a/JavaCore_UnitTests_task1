package org.example;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Employee> list = Arrays.asList(
                new Employee("Tom", 20, Sex.MAN, 65000),
                new Employee("Anna", 36, Sex.WOMAN, 78000),
                new Employee("Maria", 47, Sex.WOMAN, 100000),
                new Employee("Petr", 30, Sex.MAN, 90000),
                new Employee("Elena", 26, Sex.WOMAN, 75000),
                new Employee("Steven", 55, Sex.MAN, 120000),
                new Employee("Richard", 34, Sex.MAN, 100000),
                new Employee("Victoria", 38, Sex.WOMAN, 75000),
                new Employee("Justin", 21, Sex.MAN, 65000),
                new Employee("Olga", 36, Sex.WOMAN, 95000)
        );

        System.out.println(Employee.filterMale(list));
        System.out.println(Employee.getMaxAge(list));
        System.out.println(Employee.getAverageSalary(list));
        System.out.println(Employee.getNumberEmployees(list));
        System.out.println(Employee.sortByName(list));
    }
}
