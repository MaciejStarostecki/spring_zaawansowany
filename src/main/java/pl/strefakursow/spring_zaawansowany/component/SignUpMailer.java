package pl.strefakursow.spring_zaawansowany.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import pl.strefakursow.spring_zaawansowany.service.implementation.MailSenderServiceImplementation;

@Component
@PropertySource("classpath:email.properties")
public class SignUpMailer {

    @Value("${email.confirmation.subject}")
    private String subject;

    @Value("${email.confirmation.text}")
    private String text;

    @Value("${email.confirmation.activatedLink}")
    private String activatedLink;

    private MailSenderServiceImplementation mailSenderService;

    @Autowired
    public SignUpMailer(MailSenderServiceImplementation mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    public void sendConfirmationLink(String email, String token){

        mailSenderService.sendNewMail(email, subject, text + "\n\n" + activatedLink + token);

    }

}
