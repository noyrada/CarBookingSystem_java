package BookingCar;

public class CarBookingDao {

    private final static CarBooking[] carBookings;

    static {
        carBookings = new CarBooking[10];
    }

    public static CarBooking[] getCarBookings(){
        return carBookings;
    }
}
