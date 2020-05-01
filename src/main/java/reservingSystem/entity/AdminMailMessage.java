package reservingSystem.entity;

public class AdminMailMessage {
    private Reservation reservation;
    private String text;

    public AdminMailMessage(Reservation reservation) {
        this.reservation = reservation;
        String s = checkGender();

        setText("Dokonano nowej rezerwacji.\n" + reservation.getName() +
                s + " rezerwacji na łóżko " + reservation.getBed() +
                ", na godzinę " + reservation.getTime() + "\nAdres email klienta: " + reservation.getEmail());
    }


    private String checkGender() {
        if (reservation.getName().endsWith("a"))
            return " zarezerwowała";
        else
            return " zarezerwował";
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }
}
