import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

enum ContractType {
    PERMANENT,
    PART_TIME,
    TRAINEE
}

class Employee {
    private String name;
    private int workedHours;
    private BigDecimal additionalSalary;
    private ContractType contractType;
    private BigDecimal minSalaryPerHour;

    public Employee(String name, int workedHours, BigDecimal additionalSalary, ContractType contractType, List<Double> minSalaryList) {
        this.name = name;
        this.workedHours = workedHours;
        this.additionalSalary = additionalSalary;
        this.contractType = contractType;
        this.minSalaryPerHour = BigDecimal.valueOf(minSalaryList.get(contractType.ordinal()));
    }

    public BigDecimal salary() {
        BigDecimal hourlyRate = minSalaryPerHour.add(additionalSalary);
        return hourlyRate.multiply(BigDecimal.valueOf(workedHours));
    }

    public void increaseSalary(double percentage) {
        if (percentage > 0) {
            BigDecimal percentDecimal = BigDecimal.valueOf(percentage).divide(BigDecimal.valueOf(100));
            additionalSalary = additionalSalary.add(additionalSalary.multiply(percentDecimal));
        }
    }

    public ContractType getContractType() {
        return contractType;
    }

    public String getName() {
        return name;
    }

    // Override equals and hashCode methods to identify duplicate employees by name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Company {
    private String name;
    private int maxEmployees;
    private List<Employee> employees;

    public Company(String name, int maxEmployees) {
        this.name = name;
        this.maxEmployees = maxEmployees;
        this.employees = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        if (employees.size() < maxEmployees && !employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public void fireEmployee(Employee employee) {
        employees.remove(employee);
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

    public void increaseSalaries(double percentage) {
        if (percentage > 0) {
            for (Employee employee : employees) {
                employee.increaseSalary(percentage);
            }
        }
    }

    public BigDecimal averageSalaryByType(ContractType contractType) {
        BigDecimal totalSalary = BigDecimal.ZERO;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getContractType() == contractType) {
                totalSalary = totalSalary.add(employee.salary());
                count++;
            }
        }
        return count == 0 ? BigDecimal.ZERO : totalSalary.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String companyName = bufferedReader.readLine();
        int maxNumberOfEmployees = Integer.parseInt(bufferedReader.readLine().trim());
        List<Double> minSalaryList = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<String> namesList = Arrays.asList(bufferedReader.readLine().split(" "));
        List<Integer> workedHoursList = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<String> contractTypeList = Arrays.asList(bufferedReader.readLine().split(" "));
        List<Double> additionalSalaryList = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        String contractType = bufferedReader.readLine();
        double increasePercentage = Double.parseDouble(bufferedReader.readLine().trim());

        Company company = new Company(companyName, maxNumberOfEmployees);
        Set<Employee> hiredEmployees = new HashSet<>();

        for (int i = 0; i < namesList.size(); i++) {
            ContractType type = ContractType.valueOf(contractTypeList.get(i));
            Employee employee = new Employee(namesList.get(i), workedHoursList.get(i), BigDecimal.valueOf(additionalSalaryList.get(i)), type, minSalaryList);

            if (!hiredEmployees.contains(employee)) {
                company.hireEmployee(employee);
                hiredEmployees.add(employee);
            }
        }

        System.out.println(company.averageSalary());
        company.increaseSalaries(increasePercentage);
        System.out.println(company.averageSalary());
        System.out.println(company.averageSalaryByType(ContractType.valueOf(contractType)));

        bufferedReader.close();
    }
}
