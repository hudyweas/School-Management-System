package pl.hudyweas.schoolmanagementsystem.Entities;

import pl.hudyweas.schoolmanagementsystem.UserManagement.UserFactoryImpl;

public class Admin extends User {
    UserFactoryImpl userFactory = new UserFactoryImpl();
    User user;

    public Admin(){
        type = "admin";
    }

    public void addUser(UserTypes userType){
        user = userFactory.makeUser(userType);
    }
}
