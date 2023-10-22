package pl.javastart.task;

import java.io.*;
import java.util.*;

public class FileOperations {
    public static Queue<Vehicle> loadVehiclesFromFile(String fileName) {
        File file = new File(fileName);
        Queue<Vehicle> vehicles = new LinkedList<>();
        try (
                Scanner scan = new Scanner(file);
                ) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] lineArray = line.split(";");
                vehicles.offer(new Vehicle(lineArray[0], lineArray[1], lineArray[2], Integer.parseInt(lineArray[3]), Long.parseLong(lineArray[4]),
                        lineArray[5]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");;
        }
        return vehicles;
    }

    public static void writeQueueToFile(String filePath, Queue<Vehicle> vehicles) {
        try (
                var writer = new FileWriter(filePath);
                var bufferedWriter = new BufferedWriter(writer);
        ) {
            while (!vehicles.isEmpty()) {
                Vehicle vehicle = vehicles.poll();
                bufferedWriter.write(vehicle.getType() + ";" + vehicle.getBrand() + ";" + vehicle.getModel() + ";"
                        + vehicle.getProdYear() + ";" + vehicle.getMileage() + ";" + vehicle.getVin());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        }
    }
}
