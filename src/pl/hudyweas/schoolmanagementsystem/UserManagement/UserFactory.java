package pl.hudyweas.schoolmanagementsystem.UserManagement;

import pl.hudyweas.schoolmanagementsystem.Entities.User;
import pl.hudyweas.schoolmanagementsystem.Entities.UserTypes;

public interface UserFactory {
    public User makeUser(String userType);
}
