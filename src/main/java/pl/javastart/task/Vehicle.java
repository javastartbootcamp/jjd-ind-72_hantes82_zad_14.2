package pl.javastart.task;

public class Vehicle {

    private String type;
    private String brand;
    private String model;
    private int prodYear;
    private long mileage;
    private String vin;

    public Vehicle(String type, String brand, String model, int prodYear, long mileage, String vin) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.prodYear = prodYear;
        this.mileage = mileage;
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProdYear() {
        return prodYear;
    }

    public long getMileage() {
        return mileage;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", prodYear=" + prodYear +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                '}';
    }

    public String toCsv() {
        return type + ";" + brand + ";" + model + ";"
                + prodYear + ";" + mileage + ";" + vin;
    }
}
