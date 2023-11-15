package pl.strefakursow.spring_zaawansowany.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class CustomTaskSheduler {

//    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedDelay = 5000)
//    @Scheduled(cron = "* * * * * *") //sekunda, minuta, godzina, dzień miesiąca, miesiąc, dzień tygodnia
//    @Scheduled(cron = "${cron.expression}")
    public void doSomeStuff() {
//        Thread.sleep(1000);
        System.out.println("Some operation, time: " + LocalTime.now());
    }

}
