package pl.strefakursow.spring_zaawansowany.service.test_for_event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pl.strefakursow.spring_zaawansowany.event.UserPanelEnterEvent;

@Component
public class ListenerServiceOne implements ApplicationListener<UserPanelEnterEvent> {
    @Override
    public void onApplicationEvent(UserPanelEnterEvent event) {
        System.out.println("ListenerServiceOne received event, username: " + event.getUsername());
    }
}
