package pl.strefakursow.spring_zaawansowany.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.strefakursow.spring_zaawansowany.entity.Item;


public interface ItemPagingAndSortingRepository extends PagingAndSortingRepository<Item, Long> {

}
