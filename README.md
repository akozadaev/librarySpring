# Описание проекта "Библиотека":
Простой REST-сервер, реализующий сервис хранения, поиска информации о книгах, их авторах и жанрах, комментариям к книгам.

## Основные зависимости:
1\. Подключение зависимостей https://github.com/akozadaev/librarySpring/blob/main/pom.xml   
   1.1\. Spring-boot-starter-parent - специальный стартер для нашего мавен прокта
   1.2\. Spring Boot - непосредственно основа приложения на основе Spring
   1.3\. H2 — база данных, позволит создать проект без дополнительных установок СУБД
   1.4\. Liquibase - управление миграциями
   1.5\. Spring Data (jpa - Java Persistence API) - спецификация Java, описывающая систему управления сохранением java объектов в таблицы реляционных баз данных
   1.6\. Lombok позволит генерировать Java-код на лету из аннотаций. Повысит читаемость

## Структура проекта
1\. Project Object Model - pom.xml
2\. Конфигурация проекта - src/main/resources/application.yml
3\. Ченджлоги создания таблиц и связей - src/main/resources/db.changelog/1.0
4\. Подключение ченджлогов, учитывая порядок создания (невозможно создать связь с несуществующей таблицей) - src/main/resources/db.changelog/db.changelog-master.xml
5\. Данные для заполнения таблиц БД. src/main/resources/db.changelog/data
   5.1\. Правила пасинга CSV файлов:
         src/main/resources/db.changelog/data/2021-10-20--0001-book-data.xml
         src/main/resources/db.changelog/data/2021-10-20--0002-author-data.xml
         src/main/resources/db.changelog/data/2021-10-20--0003-genre-data.xml
         src/main/resources/db.changelog/data/2021-11-18--0004-comment-data.xml
   5.2\. CSV файлы с данными:
         db.changelog/1.0

6\. Описание сущьностей проекта - src/main/java/ru/akozadaev/entities
7\. Абстракция над сущьностями для представления в БД, DAO - src/main/java/ru/akozadaev/dao
8\. DTO для передачи между слоями представления данных - src/main/java/ru/akozadaev/rest/dto
9\. Набор контроллеров - src/main/java/ru/akozadaev/rest/controller 
10\. Набор сервисов и их интерфейсов - src/main/java/ru/akozadaev/service

## Запуск приложения 
mvn spring-boot:run

## Выполнение некоторых запросов
1\. [GET] localhost:8080/author

Ответ:

```JSON
[
    {
        "id": 1,
        "name": "Сергей Лукьяненко"
    },
    {
        "id": 2,
        "name": "Александр Сергеевич Грибоедов"
    },
    {
        "id": 3,
        "name": "Гарри Гаррисон"
    }
]
```

2\. [GET] localhost:8080/author/1

Ответ:

```JSON
{
    "id": 1,
    "name": "Сергей Лукьяненко"
}
```


3\. [GET] localhost:8080/genre

Ответ:

```JSON
[
    {
        "id": 1,
        "name": "Фэнтези"
    },
    {
        "id": 2,
        "name": "Комедия"
    },
    {
        "id": 3,
        "name": "Фантастика"
    }
]
```


4\. [POST] localhost:8080/genre

body:
{
    "id": 4,
    "name": "Хоррор"
}

Ответ:

```JSON
{
    "id": 4,
    "name": "Хоррор"
}
```


5\. [GET] localhost:8080/genre

Ответ:

```JSON
[
    {
        "id": 1,
        "name": "Фэнтези"
    },
    {
        "id": 2,
        "name": "Комедия"
    },
    {
        "id": 3,
        "name": "Фантастика"
    },
    {
        "id": 4,
        "name": "Хоррор"
    }
]
```
