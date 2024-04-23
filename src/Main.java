import Car.CarService;
import user.UserService;
import user.User;
import user.UserDao;
import Car.Car;
import Car.CarDao;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        CarService carService = new CarService();

        boolean keepLooking = true;

        while (keepLooking){
            displayMenu();
            byte optionNumber = scanner.nextByte();
            switch (optionNumber){

                case 1->System.out.println("1-Booking Car");
                case 2-> System.out.println("2-View all user booked cars");
                case 3-> System.out.println("3-view all booking");
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
