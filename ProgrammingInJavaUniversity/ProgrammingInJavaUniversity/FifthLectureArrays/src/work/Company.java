package work;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private int maxEmployeesCount;
    private List<Employee> employees;

    public Company(String name, int maxEmployeesCount) {
        this.name = name;
        this.maxEmployeesCount = maxEmployeesCount;
        this.employees = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        if (employees.size() == maxEmployeesCount) return;

        for (Employee currentEmployee : employees) {
            if (employee == currentEmployee) {
                return;
            }
        }

        employees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void increaseSalaries(double percentage) {
        if (percentage <= 0) return;

        for (Employee employee : employees) {
            employee.increaseBonusSalary(percentage);
        }
    }

    public BigDecimal averageSalary() {
        if (employees.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalSalary = BigDecimal.ZERO;

        for (Employee employee : employees) {
            totalSalary = totalSalary.add(employee.salary());
        }

        return totalSalary.divide(BigDecimal.valueOf(employees.size()), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal averageSalaryPerContractType(TypeContract typeContract) {
        BigDecimal sum = BigDecimal.valueOf(0);
        int count = 0;

        for (Employee employee : employees) {
            if (employee.typeContract == typeContract) {
                count++;
                sum = sum.add(employee.salary());
            }
        }

        return sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
    }
}
