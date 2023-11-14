package pl.strefakursow.spring_zaawansowany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.strefakursow.spring_zaawansowany.entity.Item;

import java.util.List;

public interface ItemService {

    public void saveItem(Item item);

    public List<Item> getItemWithQuantityOverTwenty();

    public List<Item> getItemsWithQuantityOver(int minQuantityThreshold);

    public List<Item> getItemsWithNameLike(String nameLike);

    public Page<Item> findAll(Pageable pageable);

}
