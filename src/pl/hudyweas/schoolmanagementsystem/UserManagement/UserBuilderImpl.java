package pl.hudyweas.schoolmanagementsystem.UserManagement;

import pl.hudyweas.schoolmanagementsystem.Entities.*;

public class UserBuilderImpl implements UserBuilder {

    @Override
    public User makeUser(String usertype) {
        switch (usertype.toUpperCase()){
            case "ADMIN":
                return new Admin();
            case "TEACHER":
                return new Teacher();
            case "STAFF_MEMBER":
                return new StaffMember();
            case "STUDENT":
                return new Student();
        }
        return null;
    }
}