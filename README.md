# Дипломный проект по профессии «Тестировщик»
Дипломный проект представляет собой комплексную автоматизацию тестирования веб-сервиса, который взаимодействует с СУБД и API банка.

## Документация:
1) [Задание дипломного проекта](https://github.com/netology-code/qa-diploma)
2) [План автоматизации дипломного проекта](https://github.com/StasyCho/QAdiplom/blob/main/Documents/Plan.md)
3) [Отчёт о проведённом тестировании](https://github.com/StasyCho/QAdiplom/blob/main/Documents/Report.md)
4) [Отчёт о проведённой автоматизации](https://github.com/StasyCho/QAdiplom/blob/main/Documents/Summary.md)


## Процедура запуска автотестов
1) Для запуска авто-тестов нужно заранее установить и запустить Docker Desktop на локальной машине

2) Запустить IntelliJ IDEA

3) Склонировать репозиторий командой в консоли: git clone git@github.com:StasyCho/QAdiplom.git

4) Запустить контейнеры Docker командой в консоли:
- docker-compose up

5) Запустить приложение командой в консоли:

- java -jar artifacts/aqa-shop.jar

6) Запустить авто-тесты командой в консоли:
- для MySQL:

./gradlew test "-Ddb.url=jdbc:mysql://localhost:3306/app" "-Ddb.username=app" "-Ddb.password=pass"

- для PostgreSQL:

./gradlew test "-Ddb.url=jdbc:postgresql://localhost:5432/app" "-Ddb.username=app" "-Ddb.password=pass"

8) Создание Allure отчёта

- ./gradlew allureReport - формирование отчёта

- ./gradlew allureServe - отображение отчёта в браузере

### После выполнения всех тестов:
- остановить работу приложения командой в консоли: Ctrl+C
- остановить работу контейнеров Docker командой в консоли: docker-compose down
