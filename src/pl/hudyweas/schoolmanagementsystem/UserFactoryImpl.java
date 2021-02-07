package pl.hudyweas.schoolmanagementsystem;

public class UserFactoryImpl implements UserFactory {

    @Override
    public User makeUser(UserTypes usertype) {
        switch (usertype.type){
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
