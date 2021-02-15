package pl.hudyweas.schoolmanagementsystem.UserManagement;

import pl.hudyweas.schoolmanagementsystem.DBConnection.DBManagementSystem;
import pl.hudyweas.schoolmanagementsystem.Entities.User;

import java.util.Scanner;

public class UserManagementSystem {
    UserFactoryImpl userFactory = new UserFactoryImpl();
    DBManagementSystem dbManagementSystem = new DBManagementSystem();

    public UserManagementSystem() {
    }

    public User createAccount(){
        Scanner in = new Scanner(System.in);

        String login;

        do {
            System.out.println("Podaj login");
            login = in.nextLine();
        }while(!dbManagementSystem.isLoginFree(login));

        System.out.println("Podaj imie");
        String firstName = in.nextLine();

        System.out.println("Podaj nazwisko");
        String lastName = in.nextLine();
        System.out.println("Podaj typ konta: teacher | student | staffmember");
        String type = in.nextLine().toLowerCase();

        User user = userFactory.makeUser(type);

        user.setFirstName(firstName);
        user.setLastName(lastName);

        dbManagementSystem.addUser(user, login);

        return user;
    }
}
