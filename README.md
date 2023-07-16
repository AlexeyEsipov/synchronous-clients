# synchronous-clients 
Этот проект написан для демонстрации способов синхронного взаимодействия сервисов в микросервисной архитектуре.
Общая схема взаимодействия осуществляется следующим образом: 
![Image of Services](images/01.png)

С базой данных работает только сервис [Source](source), а остальные сервисы общаются с ним.

Сервисы названы по наименованию технологии, применяемой при организации взаимодействия.

Сервис [RestTemplate](resttemplate) использует технологию [RestTemplate](https://spring.io/guides/gs/consuming-rest/)

Сервис [OpenFeign](openfeign) использует технологию [OpenFeign](https://cloud.spring.io/spring-cloud-openfeign/reference/html/)

Сервис [WebClient](webclient) использует технологию [WebClient](https://spring.io/guides/gs/reactive-rest-service/) в синхронном варианте.



