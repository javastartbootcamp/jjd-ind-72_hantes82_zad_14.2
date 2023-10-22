package pl.javastart.task;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String filePath = "src/main/java/resources/vehicles.csv";
        VehiclesWorkshop vehiclesWorkshop = new VehiclesWorkshop(filePath);
        Scanner scan = new Scanner(System.in);
        boolean continueProcess = false;
        do {
            int number = getNumber(scan);
            switch (number) {
                case 0 -> {
                    continueProcess = false;
                    if (!vehiclesWorkshop.getVehicles().isEmpty()) {
                        FileOperations.writeQueueToFile(filePath, vehiclesWorkshop.getVehicles());
                    }
                    System.out.println("Closing the app...");
                }
                case 1 -> {
                    vehiclesWorkshop.addNewVehicle();
                    continueProcess = true;
                }
                case 2 -> {
                    if (!vehiclesWorkshop.getVehicles().isEmpty()) {
                        Vehicle vehicle = vehiclesWorkshop.getVehicles().poll();
                        System.out.println(vehicle.toString());
                    } else {
                        System.out.println("There are no cars in the queue");
                    }
                    continueProcess = true;
                }
                default -> {
                    System.out.println("Out of range");
                    continueProcess = true;
                }
            }
        } while (continueProcess);
    }

    private static int getNumber(Scanner scan) {
        int number;
        do {
            System.out.println("Choose the option:\n0. Exit program\n1. Add a new vehicle\n2. Load next vehicle\n");
            number = scan.nextInt();
            scan.nextLine();
        } while (number < 0 || number > 2);
        return number;
    }
}
