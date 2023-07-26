# synchronous-clients 
Этот проект написан для демонстрации способов синхронного взаимодействия сервисов в микросервисной архитектуре.
Общая схема взаимодействия осуществляется следующим образом:
![Image of Services](images/01.png)

С базой данных работает только сервис [Source](source), а остальные сервисы общаются с ним.

Сервисы названы по наименованию технологии, применяемой при организации взаимодействия.

Сервис [RestTemplate](resttemplate) использует технологию [RestTemplate](https://spring.io/guides/gs/consuming-rest/)

Сервис [OpenFeign](openfeign) использует технологию [OpenFeign](https://cloud.spring.io/spring-cloud-openfeign/reference/html/)

Сервис [WebClient](webclient) использует технологию [WebClient](https://spring.io/guides/gs/reactive-rest-service/) в синхронном варианте.

Сервисы запускаются на разных портах: 
Source       - 8080
RestTemplate - 8081
OpenFeign    - 8082 
WebClient    - 8083

Для демонстрации работы склонируйте репозиторий, затем запустите общий для всех служб сервис [Source](source).
Потом выберите сервис с интересующей технологией и запустите. Порядок запуска сервисов подробно описан в файлах ReadMe.md в каждом сервисе.

## Используемые технологии:
![java](https://img.shields.io/badge/Java--17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot--2.7.12-F2F4F9?style=for-the-badge&logo=spring-boot)
![Lombok](https://img.shields.io/badge/Lombok-1.18.24-green?style=for-the-badge&logo=lombok&logoColor=white)

Перед запуском установите:
- Java 17
- Apache Maven 3.x

Порядок работы следующий. 
Запускаем сервис Source, в браузере открываем интерфейс встроенной базы данных H2.
![Image of H2 Source](images/02.png)
Затем запускаем любой сервис, например, RestTemplate. С помощью Postman
![Image of Postman RestTemplate](images/03.png)
или cUrl выполняем HTTP-запросы, и в консоли H2 
контролируем результат.
Так же используем и другие сервисы.
Более подробно порядок запуска описан в файлах ReadMe в соответствующих сервисах.
