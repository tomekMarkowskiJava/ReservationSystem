package reservingSystem.controller;

import org.springframework.stereotype.Component;
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

    private String senderEmail = "test.solarium@gmail.com";
    private String senderPassword = "xxxx";
    private Properties properties;
    private Session session;


    public void send(Reservation reservation){
        session = Session.getDefaultInstance(setProperties(), new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(senderEmail,senderPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(reservation.getEmail()));
            message.setSubject("Rezerwacja");
            message.setText("Cześć " + reservation.getName() +
                    ". Dziękujemy za rezerwację! \nZarezerwowałeś łóżko: " +reservation.getBed() );
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private Properties setProperties(){
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        return properties;
    }

}
