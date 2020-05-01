package reservingSystem.entity;

public class AdminMailMessage {
    private Reservation reservation;
    private String text;
    private String subject;

    public AdminMailMessage(Reservation reservation) {
        this.reservation = reservation;
        String s = checkGender();
        setSubject("Nowa rezerwacja - " + reservation.getName());
        setText("Dokonano nowej rezerwacji.\n" + reservation.getName() +
                s + " rezerwacji na łóżko " + reservation.getBed() +
                ", na godzinę " + reservation.getTime() + "\nAdres email klienta: " + reservation.getEmail());
    }


    private String checkGender() {
        if (reservation.getName().endsWith("a"))
            return " dokonała";
        else
            return " dokonał";
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    private void setSubject(String subject) {
        this.subject = subject;
    }
}
