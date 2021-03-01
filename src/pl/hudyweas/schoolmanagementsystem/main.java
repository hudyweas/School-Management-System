package pl.hudyweas.schoolmanagementsystem;

import pl.hudyweas.schoolmanagementsystem.Entities.User;
import pl.hudyweas.schoolmanagementsystem.UserManagement.UserManagementSystem;
import pl.hudyweas.schoolmanagementsystem.general.UserInterfaceSystem;

public class main {
    public static void main(String[] args) {
        User loggedUser = loginOrCreateAccount();
    }

    private static User loginOrCreateAccount() {
        UserManagementSystem userManagementSystem = new UserManagementSystem();
        String[] methodPoint = new String[]{"Log in", "Create account"};
        UserInterfaceSystem userInterfaceSystem = new UserInterfaceSystem(methodPoint);

        userInterfaceSystem.terminalChoiceInterface();
        int input = userInterfaceSystem.getIntInput();

        User loggedUser;

        if(input == 0){
            loggedUser = userManagementSystem.login();
        }else{
            loggedUser = userManagementSystem.createAccount();
        }

        return loggedUser;
    }
}
