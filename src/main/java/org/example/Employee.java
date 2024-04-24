package org.example;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employee {

    private final String name;
    private final int age;
    private final Sex sex;
    private final int salary;

    public Employee(String name, int age, Sex sex, int salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                sex == employee.sex &&
                salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, salary);
    }

    //Сортировка сотрудников по имени
    public static List<Employee> sortByName(Collection<Employee> list) {
        return list.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    //Получение числа сотрудников мужского пола
    public static int filterMale(Collection<Employee> list) {
        long collect = list.stream()
                .filter(employee -> employee.getSex() == Sex.MAN).count();
        return (int) collect;
    }

    //Получение имени самого взрослого сотрудника
    public static String getMaxAge(Collection<Employee> list) {
        Employee max = list.stream()
                .max(Comparator.comparing(Employee::getAge)).get();
        return max.getName();
    }

    //Получение средней заработной платы сотрудников
    public static int getAverageSalary(Collection<Employee> list) {
        int salary = 0;
        for (Employee employee : list) {
            salary += employee.getSalary();
        }
        int numberOfEmployee = list.size();
        return salary / numberOfEmployee;
    }

    //Количество сотрудников всего
    public static int getNumberEmployees(Collection<Employee> list) {
        return list.size();
    }
}

