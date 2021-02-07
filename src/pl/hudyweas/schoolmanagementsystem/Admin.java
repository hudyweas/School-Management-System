package pl.hudyweas.schoolmanagementsystem;

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
