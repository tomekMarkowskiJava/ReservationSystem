package reservingSystem.controller;

import org.springframework.stereotype.Component;
import reservingSystem.entity.AdminMailMessage;
import reservingSystem.entity.ClientMailMessage;
import reservingSystem.entity.Reservation;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailController {

    private String adminEmail = "test.solarium@gmail.com";

    private Session session = Session.getDefaultInstance(setProperties(), new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            String adminPassword = "test.solarium19";
            return new PasswordAuthentication(adminEmail, adminPassword);
        }
    });

    void sendToClient(Reservation reservation){
        ClientMailMessage clientMailMessage = new ClientMailMessage(reservation);
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(reservation.getEmail()));
            message.setSubject("Solarium Żar Tropików - rezerwacja");
            message.setText(clientMailMessage.getText());
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    void sendToAdmin(Reservation reservation) {
        AdminMailMessage adminMailMessage = new AdminMailMessage(reservation);
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(adminEmail));
            message.setSubject("Nowa rezerwacja - " + reservation.getName());
            message.setText(adminMailMessage.getText());
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Properties setProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        return properties;
    }

}
