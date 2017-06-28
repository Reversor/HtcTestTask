package reversor.test.data;

import java.util.Comparator;

import reversor.test.data.entity.Employee;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee, Employee t1) {
        return employee.getName().compareTo(t1.getName());
    }
}
