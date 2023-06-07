package ru.job4j.resttemplate.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.resttemplate.model.Item;
import java.util.Collections;
import java.util.List;
@Service
public class TrackerService {
    @Value("${source-api-url}")
    private String url;
    private final RestTemplate client;

    public TrackerService(RestTemplate client) {
        this.client = client;
    }

    public Item save(Item item) {
        return client.postForEntity(url, item, Item.class).getBody();
    }
    public boolean update(int id, Item item) {
        return client.exchange(
                "%s?id=%d".formatted(url, id),
                HttpMethod.PUT,
                new HttpEntity<>(item),
                HttpStatus.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }
    public void delete(int id) {
        client.delete("%s?id=%d".formatted(url, id));
    }
    public Item findById(int id) {
        return client.getForEntity(
                "%s/getById?id=%d".formatted(url, id),
                Item.class
        ).getBody();
    }

    public List<Item> findByName(String name) {
        return getList("%s/getByName?name=%s".formatted(url, name));
    }

    public List<Item> findAll() {
        return getList("%s/getAll".formatted(url));
    }

    private List<Item> getList(String url) {
        List<Item> body = client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Item>>() { }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
