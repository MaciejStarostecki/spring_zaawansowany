package pl.strefakursow.spring_zaawansowany.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserPanelEnterPublisher {

    private ApplicationEventPublisher applicationEventPublisher;

    public UserPanelEnterPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String username) {
        UserPanelEnterEvent event = new UserPanelEnterEvent(this, username);
        applicationEventPublisher.publishEvent(event);
    }

}
