import BookingCar.CarBookingService;
import Car.CarService;
import user.UserService;
import user.User;
import Car.Car;
import BookingCar.CarBooking;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        CarService carService = new CarService();
        CarBookingService carBookingService= new CarBookingService();

        boolean keepLooking = true;

        while (keepLooking){
            displayMenu();
            byte optionNumber = scanner.nextByte();
            switch (optionNumber){

                case 1-> bookCar(userService,carBookingService,carService,scanner);
                case 2-> displayAllUserBookingCar(userService, carBookingService,scanner);
                case 3-> displayAllBooking(carBookingService);
                case 4-> displayAllCars(carService,false);
                case 5-> displayAllCars(carService,true);
                case 6-> displayAllUser(userService);
                case 7->{
                    System.out.println("7-Exit");
                    keepLooking = false;
                }
                default-> System.out.println("Not found of Option!");
            }
        }
    }

    private static void bookCar(UserService userService, CarBookingService carBookingService, CarService carService, Scanner scanner) {
        displayAllCars(carService,false);
        System.out.println("-> Select car register number: " );
        scanner.nextLine();
        String registerNumber = scanner.nextLine();

        Car car  = carService.getCar(registerNumber);
        if(car == null){
            System.out.println("❌ No Car found with register"+ registerNumber);
            return;
        }

        displayAllUser(userService);
        System.out.println("-> select user id : ");
//        scanner.nextLine();
        String userId = scanner.nextLine();

        User user = userService.getUserById(UUID.fromString(userId));
        if (user == null){
            System.out.println("❌ No user found with id" + userId);
            return;
        }



        //implementation of carBooking:
        System.out.println(user);
        System.out.println(car);
    }

    private static void displayAllUserBookingCar(UserService userService, CarBookingService carBookingService, Scanner scanner) {

        displayAllUser(userService);
        System.out.print("->Select user id:");
        scanner.nextLine();
        String userId = scanner.nextLine();

        User user = userService.getUserById(UUID.fromString(userId));
        if (user  == null){
            System.out.println("❌ No user found!");
            return;
        }

        Car[] userBookedCars = carBookingService.getUserBookedCars(user.getId());
        if (userBookedCars == null){
            System.out.println("❌ User " + user+ "has no cars booked");
            return;
        }

        for (Car car: userBookedCars){
            System.out.println(car);
        }
    }

    private static CarBooking[] displayAllBooking(CarBookingService carBookingService) {

        CarBooking[] carBookings = carBookingService.getAllCarBookings();
        if (carBookings.length == 0){
            System.out.println("❌ No Car booking in the system!");
            return null;
        }
        for (CarBooking carBooking: carBookings){
            if (carBooking != null)
                System.out.println(carBooking);
        }
        return carBookings;
    }


    private static Car[] displayAllCars(CarService carService,boolean isElectric) {

        Car[] cars = isElectric ? carService.getAllElectricCar() : carService.getAllCar();
        if (cars.length == 0){
            System.out.println("❌ No car in the System!");
            return null;
        }
        for (Car car:cars){
            System.out.println(car);
        }
        return cars;
    }

    //case 6:
    private static User[] displayAllUser(UserService userService) {

        User[] users = userService.getUsers();
        if (users.length == 0){
            System.out.println("❌ No User int the System.");
            return null;
        }
        for (User user: users){
            System.out.println(user);
        }
        return users;
    }


    static void displayMenu(){

        System.out.println("1-Booking Car");
        System.out.println("2-View all user booked cars");
        System.out.println("3-view all booking");
        System.out.println("4-view available cars");
        System.out.println("5-view available Electric Cars");
        System.out.println("6-view all users");
        System.out.println("7-Exit");
    }
}
