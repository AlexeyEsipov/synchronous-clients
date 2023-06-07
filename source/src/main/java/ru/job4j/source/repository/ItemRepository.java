package ru.job4j.source.repository;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.source.model.Item;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findByNameIgnoreCase(String name);
}