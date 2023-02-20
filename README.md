# Итоговая аттестация

## Информация о проекте
Необходимо организовать систему учета для питомника, в котором живут домашние и вьючные животные.

## Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный репозиторий (Github, gitlub, или Bitbucket).
Разработку необходимо вести в этом репозитории, используя pull-реквесты на изменения.

Программа должна запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо разработать класс в виде конструктора животных.

## Задание
1. Используя команду cat в терминале операционной системы Linux,
создать два файла "Домашние животные" (заполнив файл собаками, кошками, хомяками)
и "Вьючные животные" (заполнив файл лошадьми, верблюдами и ослами), а затем объединить их.
Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя "Друзья человека".

### Решение

Используемые команды:

```sh
cat > pets

cat > pack_animals

cat pack_animals >> pets

cat pets

mv pets man_friends
```

2. Создать директорию, переместить туда файл.

### Решение

Используемые команды:

```sh
mkdir animals

mv man_friends animals/man_friends
```

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
4. Установить и удалить deb-пакет с помощью dpkg.
5. Выложить историю команд в терминале Ubuntu.
6. Нарисовать диаграмму, в которой есть родительский класс, домашние животные и вьючные животные,
в состав которых в случае домашних животных войдут классы: собаки, кошки, хомяки,
а в класс вьючные животные войдут: лошади, верблюды и ослы.
7. В подключенном MySQL репозитории создать базу данных “Друзья человека”.
8. Создать таблицы с иерархией из диаграммы в БД.
9. Заполнить низкоуровневые таблицы именами (животных), командами, которые они выполняют и датами рождения.
10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
Объединить таблицы лошади, и ослы в одну таблицу.
11. Создать новую таблицу “Молодые животные”, в которую попадут все животные старше 1 года, но младше 3 лет
и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
13. Создать класс с инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:

	14.1. Завести новое животное.

	14.2. Отнести животное в правильный класс.

	14.3. Посмотреть список команд, которые выполняет животное.

	14.4. Обучить животное новым командам.

	14.5. Реализовать навигационное меню.

15. Создайте класс Counter, у которого есть метод add(),
увеличивающий значение внутренней int переменной на 1 при нажатии “Завести новое животное”.
Сделать так, чтобы с объектом такого типа можно было работать в блоке try-with-resources.
Нужно пробросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт.
Значение считать в ресурсе try, если при заведении животного заполнены все поля.
