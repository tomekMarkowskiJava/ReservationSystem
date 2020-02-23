package reservingSystem.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverter {

    private Reservation reservation;

    @Autowired
    public ReservationConverter(Reservation reservation) {

        this.reservation = reservation;
    }

    public void convert(Reservation newReservation){
        reservation.setName(newReservation.getName());
        reservation.setEmail(newReservation.getEmail());
        reservation.setBed(newReservation.getBed());
        reservation.setTime(newReservation.getTime());
        reservation.setPhoneNumber(newReservation.getPhoneNumber());
    }
}
