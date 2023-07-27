# Сервис Source

Этот сервис является частью проекта  [synchronous-clients](../)

Он работает с базой данных H2, размещенной в памяти

После запуска сервиса перейдите в браузере по адресу http://localhost:8080/h2-console. Загрузится интерфейс базы данных H2:
![Image of H2 interface Source](images/09.PNG)

Подключитесь и проверьте, что таблица пустая:
![Image of H2 empty Source](images/10.PNG)

Для удобства работы к проекту подключен Swagger. Перейдите по адресу http://localhost:8080/swagger-ui/index.html
![Image of Swagger Source](images/11.PNG)

Затем перейдите по ссылке  /v3/api-docs

![Image of API Source](images/12.PNG)

Скопируйте из адресной строки браузера ссылку http://localhost:8080/v3/api-docs 
и импортируйте ее в Postman. Теперь можно выполнять запросы
![Image of Postman request Source](images/13.PNG)

и получать ответы в Postman
![Image of Postman response Source](images/14.PNG)

Контролируем изменения в базе данных
![Image of H2 state Source](images/15.PNG)

Таким образом, сервис запущен и работает. Для обращения к нему через другие сервисы выберите и запустите нужный сервис 
- Сервис [RestTemplate](resttemplate) использует технологию [RestTemplate](https://spring.io/guides/gs/consuming-rest/)
- Сервис [OpenFeign](openfeign) использует технологию [OpenFeign](https://cloud.spring.io/spring-cloud-openfeign/reference/html/)
- Сервис [WebClient](webclient) использует технологию [WebClient](https://spring.io/guides/gs/reactive-rest-service/) в синхронном варианте.





