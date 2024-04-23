package user;

import java.util.UUID;

public class UserDao {
    //code for connect to database:
    private static User[] users;
    static {
        users = new User[]{
                new User(UUID.randomUUID(),"Sok Dara"),
                new User(UUID.randomUUID(),"Sey ha"),
                new User(UUID.randomUUID(),"Ti Pong"),
                new User(UUID.randomUUID(),"Gon vida")
        };
    }

    public static User[] getUsers() {
        return users;
    }
}
