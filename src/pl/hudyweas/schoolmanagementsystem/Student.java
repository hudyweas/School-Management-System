package pl.hudyweas.schoolmanagementsystem;

public class Student extends User{
    {
        type = "student";
    }

    public Student(){

    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
