package BookingCar;
import user.User;

import Car.Car;

import java.util.UUID;

public class CarBookingService {

    public CarBooking[] getAllCarBookings(){
        return CarBookingDao.getCarBookings();
    }

    public Car[] getUserBookedCars(UUID userId){
        return  null;
    }

    public void bookCar(User user,Car car){

    }
}
