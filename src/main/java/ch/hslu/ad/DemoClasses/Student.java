package ch.hslu.ad.DemoClasses;
import java.util.Objects;

public final class Student {

    private final int ID;
    private final String firstName;
    private final String lastName;

    public Student(int id, String firstName, String lastName) {
        ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof final Student castedStudent)){
            return false;
        }
        return (castedStudent.ID == this.ID);
    }

    @Override
    public String toString() {
        return firstName+" "+lastName+" -> "+ID;
    }
}
