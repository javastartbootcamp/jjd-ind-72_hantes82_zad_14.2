package pl.javastart.task;

import java.util.*;

public class VehiclesWorkshop {
    private Queue<Vehicle> vehicles;

    public VehiclesWorkshop(String fileName) {
        this.vehicles = FileOperations.loadVehiclesFromFile(fileName);
    }

    public Queue<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addNewVehicle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Add a new vehicle to the queue");
        System.out.println("Put a type of the new vehicle");
        String type = scan.nextLine();
        System.out.println("Put a brand of the new vehicle");
        String brand = scan.nextLine();
        System.out.println("Put a model of the new vehicle");
        String model = scan.nextLine();
        System.out.println("Put a year of production of the new vehicle");
        int prodYear = scan.nextInt();
        scan.nextLine();
        System.out.println("Put a milleage of the new vehicle");
        long mileage = scan.nextLong();
        scan.nextLine();
        System.out.println("Put a VIN number of the new vehicle");
        String vin = scan.nextLine();
        vehicles.offer(new Vehicle(type, brand, model, prodYear, mileage, vin));
    }
}
