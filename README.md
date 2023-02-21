# Итоговая аттестация

## Информация о проекте
Необходимо организовать систему учета для питомника, в котором живут домашние и вьючные животные.

## Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный репозиторий (Github, gitlub, или Bitbucket).
Разработку необходимо вести в этом репозитории, используя pull-реквесты на изменения.

Программа должна запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо разработать класс в виде конструктора животных.

## Задание 1
Используя команду cat в терминале операционной системы Linux,
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

## Задание 2
Создать директорию, переместить туда файл.

### Решение

Используемые команды:

```sh
mkdir animals

mv man_friends animals/man_friends
```

## Задание 3

Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

### Решение

Скачиваем репозиторий [отсюда](https://dev.mysql.com/downloads/repo/apt/)
и перемещаем его в папку с проектом.

Запускаем команду установки:

```sh
sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
```

Обновляем информацию о пакетах:

```sh
sudo apt-get update
```

## Задание 4

Установить и удалить deb-пакет с помощью dpkg.

### Решение

Устанавливаем пакет mysql-server:

```sh
sudo apt-get install mysql-server
```

Проверяем работоспособность (отображается статус active):

```sh
systemctl status mysql
```

Смотрим информацию о пакете:
```sh
apt show mysql-server
```

Удаляем пакет:

```sh
sudo dpkg -r mysql-apt-config
```

Удаляем ненужные зависимости:
```sh
sudo apt autoremove
```

## Задание 5

Выложить историю команд в терминале Ubuntu.

### Решение

История команд представлена в соответствующих тасках выше по тексту.

## Задание 6

Нарисовать диаграмму, в которой есть родительский класс, домашние животные и вьючные животные,
в состав которых в случае домашних животных войдут классы: собаки, кошки, хомяки,
а в класс вьючные животные войдут: лошади, верблюды и ослы.

### Решение

Диаграмма "animals_diagram" прикреплена к проекту.

## Задание 7

В подключенном MySQL репозитории создать базу данных “Друзья человека”.

### Решение

Создаем новую базу данных с помощью команды:

```sql
CREATE DATABASE man_friends_db;
```

## Задание 8

Создать таблицы с иерархией из диаграммы в БД.

### Решение

Создаем таблицу с домашними животными:

```sql
CREATE TABLE `pets` (
	`ID` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
	`name` VARCHAR(45) NULL,
	`birthdate` DATE NOT NULL,
	`group` VARCHAR(20) NULL,
	PRIMARY KEY (`ID`));
```

Создаем таблицу с вьючными животными:

```sql
CREATE TABLE `pack_animals` (
        `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
        `name` VARCHAR(45) NULL,
        `birthdate` DATE NOT NULL,
        `group` VARCHAR(20) NULL,
        PRIMARY KEY (`ID`));
```

Создаем отдельную таблицу с командами:

```sql
CREATE TABLE `commands` (
        `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
        `pet_id`  INT UNSIGNED NOT NULL,
        `command_name` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`ID`));
```

## Задание 9

Заполнить низкоуровневые таблицы именами (животных), командами, которые они выполняют и датами рождения.

## Задание 10

Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
Объединить таблицы лошади, и ослы в одну таблицу.

## Задание 11

Создать новую таблицу “Молодые животные”, в которую попадут все животные старше 1 года, но младше 3 лет
и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.

## Задание 12

Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

## Задание 13

Создать класс с инкапсуляцией методов и наследованием по диаграмме.

## Задание 14

Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:

1. Завести новое животное.
2. Отнести животное в правильный класс.
3. Посмотреть список команд, которые выполняет животное.
4. Обучить животное новым командам.
5. Реализовать навигационное меню.

## Задание 15

Создайте класс Counter, у которого есть метод add(),
увеличивающий значение внутренней int переменной на 1 при нажатии “Завести новое животное”.
Сделать так, чтобы с объектом такого типа можно было работать в блоке try-with-resources.
Нужно пробросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт.
Значение считать в ресурсе try, если при заведении животного заполнены все поля.
