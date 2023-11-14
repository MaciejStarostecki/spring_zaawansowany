package pl.strefakursow.spring_zaawansowany.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.strefakursow.spring_zaawansowany.entity.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("select i from Item i where i.quantity > 20")
    public List<Item> getItemWithQuantityOverTwenty();

    @Query("select i from Item i where i.quantity >= :minQuantityThreshold")
    public List<Item> getItemsWithQuantityOver(@Param("minQuantityThreshold") int minQuantityThreshold);

    @Query("select i from Item i where i.name like :nameLike")
    public List<Item> getItemsWithNameLike(@Param("nameLike") String nameLike);

    public List<Item> findByQuantity(Item quantity);

}
