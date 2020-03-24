package reservingSystem.entity;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

@Component
public class Reservation {
    private String name;
    private String email;
    private String bed;
    private String time;

    private List <String> listOfBeds = Arrays.asList("Hawaje","Bora Bora", "Mauritius", "Dominikana", "Bali", "Seszele");

    public Reservation() {
    }

    public Reservation(String name, String email, String bed) {
        this.name = name;
        this.email = email;
        this.bed = bed;
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

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getListOfBeds() {
        return listOfBeds;
    }


    public void reset() {
        setEmail(null);
        setName(null);
        setBed(null);
        setTime(null);
    }
}
