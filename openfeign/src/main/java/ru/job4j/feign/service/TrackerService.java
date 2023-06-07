package ru.job4j.feign.service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.job4j.feign.model.Item;
import java.util.List;
@Service
public class TrackerService {
    private final TrackerProxy client;

    public TrackerService(TrackerProxy client) {
        this.client = client;
    }

    public Item save(Item item) {
        return client.save(item);
    }

    public ResponseEntity<HttpStatus> update(int id, Item item) {
        return client.update(id, item);
    }

    public void delete(int id) {
        client.delete(id);
    }

    public Item findById(int id) {
        return client.getById(id);
    }

    public List<Item> findByName(String name) {
        return client.getByName(name);
    }

    public List<Item> findAll() {
        return client.getAll();
    }
}
