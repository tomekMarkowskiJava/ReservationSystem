package reservingSystem.entity;

public class ClientMailMessage {
    private Reservation reservation;
    private String text;

    public ClientMailMessage(Reservation reservation) {
        this.reservation = reservation;
        String s = checkGender();

        setText("Cześć " + reservation.getName() +
                " :)\n Dziękujemy za rezerwację!\n" + s + " łóżko: " + reservation.getBed() +
                ", na godzinę: " + reservation.getTime() + ".\nDo zobaczenia!" +
                "\n\nPozdrawiamy, Solarium Żar Tropików.");
    }


    private String checkGender() {
        if (reservation.getName().endsWith("a"))
            return "zarezerwowałaś";
        else
            return "zarezerwowałeś";
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }
}
