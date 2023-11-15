package pl.strefakursow.spring_zaawansowany.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class UserPanelEnterEvent extends ApplicationEvent {

    @Getter
    private String username;

    public UserPanelEnterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
}
