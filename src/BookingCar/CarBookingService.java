package BookingCar;

import Car.Car;

public class CarBookingService {

    public CarBooking[] getAllCarBookings(){
        return CarBookingDao.getCarBookings();
    }
}
