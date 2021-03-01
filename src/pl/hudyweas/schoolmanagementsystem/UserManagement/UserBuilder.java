package pl.hudyweas.schoolmanagementsystem.UserManagement;

import pl.hudyweas.schoolmanagementsystem.Entities.User;
import pl.hudyweas.schoolmanagementsystem.Entities.UserTypes;

public interface UserBuilder {
    public User makeUser(String userType);
}
