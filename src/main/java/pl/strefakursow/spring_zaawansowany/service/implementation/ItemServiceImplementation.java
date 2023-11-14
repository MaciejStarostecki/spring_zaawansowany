package pl.strefakursow.spring_zaawansowany.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.strefakursow.spring_zaawansowany.entity.Item;
import pl.strefakursow.spring_zaawansowany.repository.ItemPagingAndSortingRepository;
import pl.strefakursow.spring_zaawansowany.repository.ItemRepository;
import pl.strefakursow.spring_zaawansowany.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImplementation implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemPagingAndSortingRepository itemPagingAndSortingRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);

    }

    @Override
    public List<Item> getItemWithQuantityOverTwenty() {
        return itemRepository.getItemWithQuantityOverTwenty();
    }

    @Override
    public List<Item> getItemsWithQuantityOver(int minQuantityThreshold) {
        return itemRepository.getItemsWithQuantityOver(minQuantityThreshold);
    }

    @Override
    public List<Item> getItemsWithNameLike(String nameLike) {
        return itemRepository.getItemsWithNameLike(nameLike);
    }

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return itemPagingAndSortingRepository.findAll(pageable);
    }


}
