package reservingSystem.entity;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
public class Reservation {
    private String name;
    private String email;
    private String phoneNumber;
    private String bed;
    private Time time;
//    private int numberOfMinutes;
    public List <String> listOfBeds;

    public Reservation() {
    }

    public Reservation(String name, String email, String bed) {
        this.name = name;
        this.email = email;
        this.bed = bed;

        listOfBeds.add("Hawaje");
        listOfBeds.add("Bora Bora");
        listOfBeds.add("Mauritius");
        listOfBeds.add("Dominikana");
        listOfBeds.add("Bali");
        listOfBeds.add("Seszele");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<String> getListOfBeds() {
        return listOfBeds;
    }

    public void reset() {
        setEmail(null);
        setName(null);
        setBed(null);
        setPhoneNumber(null);
        setTime(null);
    }
}
