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

- java -jar aqa-shop.jar

6) Запустить симулятор:

- cd gate-simulator
- npm start

### После выполнения всех тестов:
- остановить работу приложения командой в консоли: Ctrl+C
- остановить работу контейнеров Docker командой в консоли: docker-compose down
