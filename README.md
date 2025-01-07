
 * http://localhost:8080/employee/all - покидать запросы на шлюз через Postman
 * http://localhost:8080/employee/1 - по айди
 * **POST** http://localhost:8080/employee/new
 ``` json
{
    "id": null,
    "name": "John Doe",
    "position": "Developer",
    "salary": 70000,
    "hireDate": "2023-01-01"
}
 ```
 * **PUT** http://localhost:8080/employee/update
 ``` json
{
    "id": 1,
    "name": "Jane Doe",
    "position": "Senior Developer",
    "salary": 90000,
    "hireDate": "2023-01-01"
}
 ```
 * **DELETE** http://localhost:8080/employee/2
 * http://localhost:15672/#/ - посмотреть работу RabbitMQ (логин: guest, пароль: guest);
 * http://localhost:8080/actuator/metrics - посмотреть, какие метрики отдаёт шлюз;
 * http://localhost:8080/actuator/prometheus - посмотреть сами метрики;
 * http://localhost:9090/query - поделать запросы к Prometheus;
 * http://localhost:3000/dashboards - посмотреть дашборды в Grafana (логин: admin, пароль: admin);
 * http://localhost:5601/app/discover - - посмотреть логи в Kibana;
