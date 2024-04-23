package Car;

public class Car {
    private String registerNumber;
    private double rentalPricePerDay;
    private String brand;
    private boolean isElectric;

    public Car(String registerNumber, double rentalPricePerDay, String brand, boolean isElectric) {
        this.registerNumber = registerNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registerNumber='" + registerNumber + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand='" + brand + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }
}
