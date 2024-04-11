import work.Company;
import work.Employee;
import work.TypeContract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            TypeContract type = TypeContract.valueOf(contractTypeList.get(i));
            Employee employee = new Employee(namesList.get(i), workedHoursList.get(i), type, BigDecimal.valueOf(additionalSalaryList.get(i)), minSalaryList);

            if (!hiredEmployees.contains(employee)) {
                company.hireEmployee(employee);
                hiredEmployees.add(employee);
            }
        }

        System.out.println(company.averageSalary());
        company.increaseSalaries(increasePercentage);
        System.out.println(company.averageSalary());
        System.out.println(company.averageSalaryPerContractType(TypeContract.valueOf(contractType)));

        bufferedReader.close();
    }
}
