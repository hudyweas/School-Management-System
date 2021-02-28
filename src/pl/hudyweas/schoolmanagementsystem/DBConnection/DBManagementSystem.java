package pl.hudyweas.schoolmanagementsystem.DBConnection;

import pl.hudyweas.schoolmanagementsystem.Entities.StaffMember;
import pl.hudyweas.schoolmanagementsystem.Entities.Student;
import pl.hudyweas.schoolmanagementsystem.Entities.Teacher;
import pl.hudyweas.schoolmanagementsystem.Entities.User;

import java.util.ArrayList;

public class DBManagementSystem {
    DBConnectionSystem database = new DBConnectionSystem();

    public DBManagementSystem() {
    }

    public boolean isLoginAvailable(String login){
        String query = "SELECT 1 AS 'XD' WHERE EXISTS (SELECT login FROM accounts WHERE login='"+login+"')";
        boolean isFree = database.getResultAsArrayList(query, "XD").isEmpty();
        return isFree;
    }

    public ArrayList<String> getUserDataByUserID(String userID){
        String query = "SELECT first_name, second_name, userType FROM users WHERE UserID ="+userID;
        ArrayList<String> data = database.getResultAsArrayList(query, "first_name", "second_name", "userType");

        return data;
    }

    public void addUser(User user, String login){
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String birthDate = user.getBirthDate();
        String address = user.getAddress();
        String city= user.getCity();
        String ZIPcode = user.getZIPcode();
        String email = user.getEmail();
        String phoneNumber = user.getPhoneNumber();
        String type = user.getType();

        String query = "INSERT INTO `users` (`UserID`, `first_name`, `second_name`, `email_address`, `phone_number`, `address`, `city`, `ZIP_number`, `birthdate`, `userType`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '', '', '', '', '', '','"+type+"')";
        database.updateData(query);

        String userID = getUserId(user);

        if(type.equals("student")){
            addStudent(userID);
        }else if(type.equals("teacher")){
            addTeacher(userID);
        }else{
            addStaffMember(userID);
        }

        addAccount(userID, login);
    }

    public void addAccount(String userID, String login){
        String query = "INSERT INTO `accounts` (`AccountID`, `login`, `password`, `user_id`) VALUES (NULL, '"+login+"', '', '"+userID+"')";
        database.updateData(query);
    }

    public String getUserId(User user){
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        String query = "SELECT `UserID` from `users` WHERE `first_name`='"+firstName+"' AND `second_name`='"+lastName+"' ORDER BY `UserID` DESC";
        ArrayList<String> userId = database.getResultAsArrayList(query, "UserID");

        return userId.get(0);
    }

    public String getUserId(String login){
        String query = "SELECT `user_id` FROM accounts WHERE login='"+login+"'";
        String userID = database.getResultAsArrayList(query, "user_id").get(0);

        return userID;
    }

    public void addStudent(String userID){
        String query = "INSERT INTO `students` (`StudentID`, `userID`) VALUES (NULL, '"+userID+"')";
        database.updateData(query);
    }

    public void addTeacher(String userID){
        String query = "INSERT INTO `teachers` (`StudentID`, `userID`) VALUES (NULL, '"+userID+"')";
        database.updateData(query);
    }

    public void addStaffMember(String userID){
        String query = "INSERT INTO `staff_members` (`StudentID`, `userID`) VALUES (NULL, '"+userID+"')";
        database.updateData(query);
    }
}
