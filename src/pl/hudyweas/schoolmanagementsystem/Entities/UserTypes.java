package pl.hudyweas.schoolmanagementsystem.Entities;

public enum UserTypes {
    STUDENT("STUDENT"),
    STAFF_MEMBER("STAFF_MEMBER"),
    ADMIN("ADMIN"),
    TEACHER("TEACHER");

    String type;

    UserTypes(String userType){
        this.type = userType.toUpperCase();
    }

    public String getType() {
        return type;
    }
}
