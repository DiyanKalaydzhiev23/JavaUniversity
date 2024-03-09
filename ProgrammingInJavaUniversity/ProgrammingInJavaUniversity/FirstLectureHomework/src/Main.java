import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static int countNumbersBiggerThanDiff() {
        Scanner scanner = new Scanner(System.in);

        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();
        int diff = scanner.nextInt();

        if (startNum < 0 || endNum < 0) {
            return 0;
        }

        int count = 0;

        for (int num = startNum; num <= endNum; num++) {
            String numString = Integer.toString(num);
            String newNum = numString.substring(1) + numString.charAt(0);
            int newNumInt = Integer.parseInt(newNum);

            if ((newNumInt - num) > diff) {
                count++;
            }
        }

        return count;
    }

    public static int getSumFromSandClock() {
        Scanner scanner = new Scanner(System.in);

        int maxNum = scanner.nextInt();
        int sum = 0;
        int countOnRow = 4;

        if (maxNum < 1 || maxNum > 9) {
            return 0;
        }

        for (int currNum = 1; currNum <= maxNum; currNum++) {
            sum += countOnRow * currNum;
            countOnRow += 4;
        }

        sum -= maxNum * 2;

        return sum;
    }

    public static void getManagerInfo() {
        Scanner scanner = new Scanner(System.in);

        String employeeName = scanner.nextLine();

        int yearOfEntry = scanner.nextInt();
        int monthOfEntry = scanner.nextInt();
        int dayOfEntry = scanner.nextInt();

        int todayYear = scanner.nextInt();
        int todayMonth = scanner.nextInt();
        int todayDay = scanner.nextInt();

        scanner.close();

        Manager manager = new Manager(employeeName);

        manager.setHiringDate(LocalDate.of(yearOfEntry, monthOfEntry, dayOfEntry));
        System.out.println(manager.getHiringDate());

        System.out.println(manager.getEmployeeYearsInCompany(LocalDate.of(todayYear, todayMonth, todayDay)));
    }

    public static void getStudioInfo() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long id = Long.parseLong(bufferedReader.readLine().trim());
        int maxWorkingHours = Integer.parseInt(bufferedReader.readLine().trim());
        BigDecimal minPricePerHour = BigDecimal.valueOf(Double.parseDouble(bufferedReader.readLine().trim()));
        BigDecimal currencyEuro = BigDecimal.valueOf(Double.parseDouble(bufferedReader.readLine().trim()));
        BigDecimal pricePerHour = BigDecimal.valueOf(Double.parseDouble(bufferedReader.readLine().trim()));
        int workedHours = Integer.parseInt(bufferedReader.readLine().trim());

        Studio studio1 = new Studio(id, maxWorkingHours);

        Studio.setMinPriceForOneHour(minPricePerHour);
        studio1.setEuroRate(currencyEuro);
        studio1.setPriceForOneHour(pricePerHour);
        studio1.setRentedDayHours(workedHours);

        System.out.println(studio1.getRevenueForADayInLeva());
        System.out.println(studio1.getRevenueForADayInEuro());

        long id2 = Long.parseLong(bufferedReader.readLine().trim());
        int maxWorkingHours2 = Integer.parseInt(bufferedReader.readLine().trim());
        BigDecimal pricePerHour2 = BigDecimal.valueOf(Double.parseDouble(bufferedReader.readLine().trim()));
        int workedHours2 = Integer.parseInt(bufferedReader.readLine().trim());

        Studio studio2 = new Studio(id2, maxWorkingHours2);

        studio2.setPriceForOneHour(pricePerHour2);
        studio2.setRentedDayHours(workedHours2);

        System.out.println(studio1.compareByPriceForOneHour(studio2).getId());

        System.out.println(studio1.compareByRevenue(studio2));

        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
        getStudioInfo();
    }
}