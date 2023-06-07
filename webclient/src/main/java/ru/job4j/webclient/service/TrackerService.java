package ru.job4j.webclient.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.job4j.webclient.model.Item;
import java.util.Collections;
import java.util.List;
@Service
public class TrackerService {
    @Value("${source-api-url}")
    private String url;
    private final WebClient client;

    public TrackerService(WebClient client) {
        this.client = client;
    }

    public Item save(Item item) {
        return client
                .post()
                .bodyValue(item)
                .retrieve()
                .bodyToMono(Item.class)
                .block();
    }

    public boolean update(int id, Item item) {
        return client
                .put()
                .uri("%s?id=%d".formatted(url, id))
                .bodyValue(item)
                .retrieve()
                .toEntity(HttpStatus.class)
                .block()
                .getStatusCode()
                .is2xxSuccessful();
    }

    public void delete(int id) {
        client.delete()
                .uri("%s?id=%d".formatted(url, id))
                .retrieve()
                .toEntity(HttpStatus.class)
                .block();
    }

    public Item findById(int id) {
        return client
                .get()
                .uri("%s/getById?id=%d".formatted(url, id))
                .retrieve()
                .bodyToMono(Item.class)
                .block();
    }

    public List<Item> findByName(String name) {
        return getList("%s/getByName?name=%s".formatted(url, name));
    }

    public List<Item> findAll() {
        return getList("%s/getAll".formatted(url));
    }

    private List<Item> getList(String url) {
        List<Item> body = client
                            .get()
                            .uri(url)
                            .retrieve()
                            .bodyToMono(new ParameterizedTypeReference<List<Item>>(){})
                            .block();
        return body == null ? Collections.emptyList() : body;
    }
}
