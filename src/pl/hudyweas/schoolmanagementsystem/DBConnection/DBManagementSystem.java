package pl.hudyweas.schoolmanagementsystem.DBConnection;

import pl.hudyweas.schoolmanagementsystem.Entities.StaffMember;
import pl.hudyweas.schoolmanagementsystem.Entities.Student;
import pl.hudyweas.schoolmanagementsystem.Entities.Teacher;

public class DBManagementSystem {
    DBConnectionSystem database = new DBConnectionSystem();

    public DBManagementSystem() {
    }

    public void addStudent(Student student){
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        String birthDate = student.getBirthDate();
        String address = student.getAddress();
        String city= student.getCity();
        String ZIPcode = student.getZIPcode();
        String email = student.getEmail();
        String phoneNumber = student.getPhoneNumber();
        String studentClass = student.getStudentClass();

        String query = "INSERT INTO `students` (`UserID`, `first_name`, `second_name`, `email_address`, `phone_number`, `address`, `city`, `ZIP_number`, `birthdate`, `class`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '"+email+"', '"+phoneNumber+"', '"+address+"', '"+city+"', '"+ZIPcode+"', '"+birthDate+"', '"+studentClass+"')";
        database.updateData(query);
    }

    public void addTeacher(Teacher teacher){
        String firstName = teacher.getFirstName();
        String lastName = teacher.getLastName();
        String birthDate = teacher.getBirthDate();
        String address = teacher.getAddress();
        String city= teacher.getCity();
        String ZIPcode = teacher.getZIPcode();
        String email = teacher.getEmail();
        String phoneNumber = teacher.getPhoneNumber();
        String studentClass = teacher.getStudentClass();

        String query = "INSERT INTO `teachers` (`UserID`, `first_name`, `second_name`, `email_address`, `phone_number`, `address`, `city`, `ZIP_number`, `birthdate`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '"+email+"', '"+phoneNumber+"', '"+address+"', '"+city+"', '"+ZIPcode+"', '"+birthDate+"')";
        database.updateData(query);

    }

    public void addStaffMember(StaffMember staffMember){
        String firstName = staffMember.getFirstName();
        String lastName = staffMember.getLastName();
        String birthDate = staffMember.getBirthDate();
        String address = staffMember.getAddress();
        String city= staffMember.getCity();
        String ZIPcode = staffMember.getZIPcode();
        String email = staffMember.getEmail();
        String phoneNumber = staffMember.getPhoneNumber();
        String studentClass = staffMember.getStudentClass();

        String query = "INSERT INTO `staff_members` (`UserID`, `first_name`, `second_name`, `email_address`, `phone_number`, `address`, `city`, `ZIP_number`, `birthdate`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '"+email+"', '"+phoneNumber+"', '"+address+"', '"+city+"', '"+ZIPcode+"', '"+birthDate+"')";
        database.updateData(query);

    }
}
