package reservingSystem.entity;

import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class Reservation {
    private int id;
    private String name;
    private String email;
    private String number;

    private String bed;
    private Time time;
//    private int numberOfMinutes;

    public Reservation() {
        name="";
        email="";
    }

    public Reservation(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
}
