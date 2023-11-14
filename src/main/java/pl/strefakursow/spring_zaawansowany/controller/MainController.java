package pl.strefakursow.spring_zaawansowany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.spring_zaawansowany.entity.Item;
import pl.strefakursow.spring_zaawansowany.service.ItemService;
import pl.strefakursow.spring_zaawansowany.service.implementation.MailSenderServiceImplementation;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private static final int PAGE_SIZE = 3;

    @Autowired
    private MailSenderServiceImplementation mailSenderService;

    @Autowired
    ItemService itemService;

    @RequestMapping("/")
    public List<Item> index() {
        return itemService.getItemWithQuantityOverTwenty();
    }

    @RequestMapping("/quantity_threshold")
    public List<Item> quantityThreshold(@RequestParam(name = "quantity") Optional<Integer> quantityParam) {
        int quantity = 50;
        if (quantityParam.isPresent())
            quantity = quantityParam.get();
        return itemService.getItemsWithQuantityOver(quantity);
    }

    @RequestMapping("/find_by_name")
    public List<Item> findByName(@RequestParam(name = "name") Optional<String> nameParam) {
        String name = "%";
        if (nameParam.isPresent())
            name = nameParam.get();
        return itemService.getItemsWithNameLike(name);
    }

    @RequestMapping("/items")
    public List<Item> items(@RequestParam(defaultValue = "0") String page) {
        int currentPage = Integer.parseInt(page);
        PageRequest pageRequest = PageRequest.of(currentPage, PAGE_SIZE);

        Page<Item> pages = itemService.findAll(pageRequest);

        return pages.getContent();

    }

    @RequestMapping("/send_mail")
    public String sendMail() {
        mailSenderService.sendNewMail("ratunek.m.s.p@gmail.com", "Test", "Test Message");
        return "Mail sent!";
    }


}
