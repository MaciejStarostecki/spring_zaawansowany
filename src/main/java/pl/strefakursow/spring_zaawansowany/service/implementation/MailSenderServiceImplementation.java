package pl.strefakursow.spring_zaawansowany.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImplementation {

    private JavaMailSender mailSender;

    @Autowired
    public MailSenderServiceImplementation(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendNewMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}
