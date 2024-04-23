package user;

import java.util.UUID;

public class UserService {
    //

    public User[] getUsers(){
        return UserDao.getUsers();
    }
    public User getUserById(UUID id){
        for (User user:getUsers()){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
