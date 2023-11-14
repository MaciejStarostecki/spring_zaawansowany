package pl.strefakursow.spring_zaawansowany.service;

public interface MailSenderService {

    public void sendNewMail(String to, String subject, String body);

}
