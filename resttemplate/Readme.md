# Сервис RestTemplate

Этот сервис является частью проекта  [synchronous-clients](../)
## Запуск приложения

- Запуск приложения производится с использованием maven.
  Перейдите в каталог сервиса и в командной строке выполните команду
```
    cd resttemplate
```
- Затем выполните команды:
```
    mvn clean install
    mvn spring-boot:run
```
### Описание:

Сервис RestTemplate взаимодействует с сервисом [Source](../source). Сервис Source должен быть запущен.

Проверим это\
![Image of H2 empty Source](images/016.PNG)

Запустите сервис RestTemplate. Он будет работать на порту 8081.

Для удобства работы к проекту подключен Swagger. Перейдите по адресу http://localhost:8081/swagger-ui/index.html
![Image of Swagger Source](images/017.PNG)

Затем перейдите по ссылке  /v3/api-docs

![Image of API Source](images/018.PNG)

Скопируйте из адресной строки браузера ссылку http://localhost:8080/v3/api-docs

и импортируйте ее в Postman. Теперь можно выполнять запросы
![Image of Postman request Source](images/019.PNG)

и получать ответы в Postman
![Image of Postman response Source](images/020.PNG)

Контролируем изменения в базе данных
![Image of H2 state Source](images/021.PNG)

Таким образом, мы связали два сервиса, работающие на разных портах. Для демонстрации работы других сервисов перейдите по ссылкам:
- Сервис [OpenFeign](../openfeign) 
- Сервис [WebClient](../webclient) 





