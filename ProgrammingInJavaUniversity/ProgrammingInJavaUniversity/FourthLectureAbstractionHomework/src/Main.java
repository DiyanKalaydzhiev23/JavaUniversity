import delivery.Deliverable;
import delivery.Document;
import delivery.Material;
import delivery.WeightedItem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String materialName = scanner.nextLine();

        int fragile = scanner.nextInt();
        boolean isFragile = (fragile == 1);
        int clientsAddress = scanner.nextInt();
        boolean toClientsAddress = (clientsAddress == 1);
        double minPrice = scanner.nextDouble();
        double weight = scanner.nextDouble();
        double pricePerKg = scanner.nextDouble();
        double additionalPrice = scanner.nextDouble();

        scanner.close();

        Material material = new Material(materialName, isFragile);

        Deliverable deliverable = new Document(minPrice, toClientsAddress);

        if (toClientsAddress) {
            Document.setExtraPrice(additionalPrice);
        }

        System.out.println(deliverable.deliveryPrice());

        deliverable = new WeightedItem(material, weight, pricePerKg, toClientsAddress);

        if (toClientsAddress) {
            WeightedItem.setExtraPrice(additionalPrice);
        }

        System.out.println(deliverable.deliveryPrice());
    }
}