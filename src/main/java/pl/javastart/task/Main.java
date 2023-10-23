package pl.javastart.task;

import java.util.*;

public class Main {
    static final int SAVE_TO_FILE_AND_CLOSE = 0;
    static final int ADD_NEW_VEHICLE_TO_QUEUE = 1;
    static final int CHECK_NEXT_VEHICLE_FROM_QUEUE = 2;

    public static void main(String[] args) {

        String filePath = "src/main/java/resources/vehicles.csv";
        VehiclesWorkshop vehiclesWorkshop = new VehiclesWorkshop(filePath);
        Scanner scan = new Scanner(System.in);
        boolean continueProcess = false;
        do {
            int number = getNumber(scan);
            switch (number) {
                case SAVE_TO_FILE_AND_CLOSE -> {
                    continueProcess = false;
                    FileOperations.writeQueueToFile(filePath, vehiclesWorkshop.getVehicles());
                    System.out.println("Closing the app...");
                }
                case ADD_NEW_VEHICLE_TO_QUEUE -> {
                    vehiclesWorkshop.addNewVehicle();
                    continueProcess = true;
                }
                case CHECK_NEXT_VEHICLE_FROM_QUEUE -> {
                    serveNextVehicle(vehiclesWorkshop);
                    continueProcess = true;
                }
                default -> {
                    System.out.println("Out of range");
                    continueProcess = true;
                }
            }
        } while (continueProcess);
    }

    private static void serveNextVehicle(VehiclesWorkshop vehiclesWorkshop) {
        if (!vehiclesWorkshop.getVehicles().isEmpty()) {
            Vehicle vehicle = vehiclesWorkshop.getVehicles().poll();
            System.out.println(vehicle);
        } else {
            System.out.println("There are no cars in the queue");
        }
    }

    private static int getNumber(Scanner scan) {
        int number;
        do {
            System.out.println("Choose the option:\n0. Exit program\n1. Add a new vehicle\n2. Load next vehicle\n");
            number = scan.nextInt();
            scan.nextLine();
        } while (number < SAVE_TO_FILE_AND_CLOSE || number > CHECK_NEXT_VEHICLE_FROM_QUEUE);
        return number;
    }
}
