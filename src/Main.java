import java.nio.file.attribute.UserPrincipal;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();

        boolean keepLooking = true;

        while (keepLooking){
            displayMenu();
            byte optionNumber = scanner.nextByte();
            switch (optionNumber){

                case 1->System.out.println("1-Booking Car");
                case 2-> System.out.println("2-View all user booked cars");
                case 3-> System.out.println("3-view all booking");
                case 4-> System.out.println("4-view available cars");
                case 5-> System.out.println("5-view available Electric Cars");
                case 6-> displayAllUser(userService);
                case 7->{
                    System.out.println("7-Exit");
                    keepLooking = false;
                }
                default-> System.out.println("Not found of Option!");
            }
        }
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
