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

    public CarBooking bookCar(User user,Car car){
        return CarBookingDao.book(user,car);
    }
}
