import appliances.Cooker;
import appliances.ElectricDevice;
import appliances.Manufacturer;
import appliances.WashingMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String manufacturerName = scanner.nextLine();
        boolean givesExtraWarranty = scanner.nextInt() == 1;
        int minMonthsWarranty = scanner.nextInt();
        boolean isOnGas = scanner.nextInt() == 1;
        boolean hasDryFunction = scanner.nextInt() == 1;

        Manufacturer manufacturer = new Manufacturer(manufacturerName, givesExtraWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer, minMonthsWarranty);
        Cooker cooker = new Cooker(electricDevice, minMonthsWarranty, isOnGas);
        WashingMachine washingMachine = new WashingMachine(electricDevice, minMonthsWarranty, hasDryFunction);

        System.out.println(electricDevice.warranty());
        System.out.println(cooker.warranty());
        System.out.println(washingMachine.warranty());

        scanner.close();
    }
}