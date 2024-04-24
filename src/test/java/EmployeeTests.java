import org.example.Employee;
import org.example.Sex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class EmployeeTests {
    Collection<Employee> list;

    @BeforeEach
    public void setUp() {
        list = Arrays.asList(
                new Employee("Tom", 20, Sex.MAN, 65000),
                new Employee("Anna", 36, Sex.WOMAN, 78000),
                new Employee("Petr", 30, Sex.MAN, 90000),
                new Employee("Steven", 55, Sex.MAN, 120000),
                new Employee("Justin", 21, Sex.MAN, 65000),
                new Employee("Olga", 36, Sex.WOMAN, 95000)
        );
    }

    @Test
    public void testFilterMale() {
        int actual = Employee.filterMale(list);
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSortByName() {
        Collection<Employee> actual = Employee.sortByName(list);

        Collection<Employee> expected = new ArrayList<>();
        expected.add(new Employee("Anna", 36, Sex.WOMAN, 78000));
        expected.add(new Employee("Justin", 21, Sex.MAN, 65000));
        expected.add(new Employee("Olga", 36, Sex.WOMAN, 95000));
        expected.add(new Employee("Petr", 30, Sex.MAN, 90000));
        expected.add(new Employee("Steven", 55, Sex.MAN, 120000));
        expected.add(new Employee("Tom", 20, Sex.MAN, 65000));

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Steven", "Tom", "Olga"})
    public void parametrizedTestGetMaxAge(String expected) {
        String actual = Employee.getMaxAge(list);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageSalary() {
        int actual = Employee.getAverageSalary(list);
        int expected = (65000 + 78000 + 90000 + 120000 + 65000 + 95000) / 6;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberEmployees() {
        int actual = Employee.getNumberEmployees(list);
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }
}
