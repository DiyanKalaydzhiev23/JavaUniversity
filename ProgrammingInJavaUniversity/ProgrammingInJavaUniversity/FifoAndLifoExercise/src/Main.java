import java.io.*;
import java.util.*;
import java.util.stream.*;

class Vehicle {
    private String brand;
    private boolean emergencyVehicle;
    private double weight;

    public Vehicle(String brand, boolean emergencyVehicle, double weight) {
        this.brand = brand;
        this.emergencyVehicle = emergencyVehicle;
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isEmergencyVehicle() {
        return emergencyVehicle;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", emergencyVehicle=" + emergencyVehicle +
                ", weight=" + weight +
                '}';
    }
}

class VehicleServiceImpl {

    public Comparator<Vehicle> comparatorByWeight() {
        return Comparator.comparingDouble(Vehicle::getWeight).reversed();
    }

    public Comparator<Vehicle> comparatorByEmergency() {
        return Comparator.comparing(Vehicle::isEmergencyVehicle).reversed();
    }

    public void removeVehiclesByWeight(List<Vehicle> vehicles) {
        PriorityQueue<Vehicle> priorityQueue = new PriorityQueue<>(comparatorByWeight());
        priorityQueue.addAll(vehicles);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public void removeVehiclesByEmergency(List<Vehicle> vehicles) {
        PriorityQueue<Vehicle> priorityQueue = new PriorityQueue<>(comparatorByEmergency());
        priorityQueue.addAll(vehicles);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public void removeVehiclesFifo(List<Vehicle> vehicles) {
        Queue<Vehicle> queue = new LinkedList<>(vehicles);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public void removeVehiclesLifo(List<Vehicle> vehicles) {
        Deque<Vehicle> stack = new LinkedList<>(vehicles);
        while (!stack.isEmpty()) {
            System.out.println(stack.pollLast());
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> brandList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(Collectors.toList());

        List<Boolean> emergencyList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(e -> Integer.parseInt(e) != 0)
                .collect(Collectors.toList());

        List<Double> weightList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        // Create 5 vehicles using the values in the brandList, emergencyList, and weightList.
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < brandList.size(); i++) {
            vehicles.add(new Vehicle(brandList.get(i), emergencyList.get(i), weightList.get(i)));
        }

        // Create an object of the type VehicleServiceImpl
        VehicleServiceImpl service = new VehicleServiceImpl();

        // Use the vehicles list as a parameter, when the methods of the VehicleServiceImpl are called
        // Call removeVehiclesByWeight()
        service.removeVehiclesByWeight(vehicles);

        // Print new line
        System.out.println();

        // Call removeVehiclesByEmergency()
        service.removeVehiclesByEmergency(vehicles);

        // Print new line
        System.out.println();

        // Call removeVehiclesFifo()
        service.removeVehiclesFifo(vehicles);

        // Print new line
        System.out.println();

        // Call removeVehiclesLifo()
        service.removeVehiclesLifo(vehicles);

        bufferedReader.close();
    }
}
