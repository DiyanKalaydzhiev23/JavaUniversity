import shop.Goods;
import shop.Sellable;
import shop.Vehicle;

public class Main {
    public static void main(String[] args) {
        Sellable sellable;
        Goods goods;

        Vehicle nissan = new Vehicle(10, 3000, 4000);
        Vehicle toyota = new Vehicle(20, 6000, 5000);

        sellable = nissan;
        goods = toyota;

        System.out.println(sellable);
        System.out.println(goods);

        System.out.println(nissan);
        System.out.println(toyota);

        System.out.println(nissan.productionPrice());
        System.out.println(toyota.productionPrice());

        System.out.println(nissan.sellingPrice());
        System.out.println(toyota.sellingPrice());
    }
}