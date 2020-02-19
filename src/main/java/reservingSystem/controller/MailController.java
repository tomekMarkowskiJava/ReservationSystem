package reservingSystem.controller;

import org.springframework.stereotype.Component;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Component
public class MailController {

    private String senderEmail = "test.solarium@gmail.com";
    private String senderPassword = "test.solarium19";
    private Properties properties;
    private Session session;

    public void send(String recipientName, String recipientEmail){
        session = Session.getDefaultInstance(setProperties(), new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(senderEmail,senderPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Rezerwacja");
            message.setText("Cześć " + recipientName + ". Dziękujemy za rezerwację!");
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
