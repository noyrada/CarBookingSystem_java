package BookingCar;
import user.User;
import Car.Car;

import java.util.Date;
import java.util.UUID;

public class CarBookingDao {

    private static CarBooking[] carBookings;

    static {
        carBookings = new CarBooking[10];
    }

    public static CarBooking[] getCarBookings(){
        return carBookings;
    }

    public static void setCarBookings(CarBooking[] newCarBookings){
        carBookings = newCarBookings;
    }

    public static CarBooking book(User user, Car car){

            CarBooking carBooking = new CarBooking(UUID.randomUUID(),user,car,new Date(),false);
            int freeIndex = -1;
            for (int i=0;i<carBookings.length;i++){
                if (carBookings[i] == null) {
                    freeIndex = i;
                }
            }
            if (freeIndex >-1){
                carBookings[freeIndex] = carBooking;
                return carBooking;
            }

            CarBooking[] biggerCarBookings = new CarBooking[carBookings.length + 10];
            for (int i=0; i<carBookings.length;i++){
                biggerCarBookings[i] = carBookings[i];
            }
            biggerCarBookings[carBookings.length] = carBooking;
            carBookings = biggerCarBookings;
            setCarBookings(biggerCarBookings);
            return carBooking;
    }
}
