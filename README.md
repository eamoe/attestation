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

### Решение

Добавляем данные в таблицу pets:

```sql
INSERT INTO pets (name, birthdate, pets.group)
VALUES 	ROW("dog1", '2010-01-01', 'dogs'),
    	ROW("dog2", '2011-01-01', 'dogs'),
    	ROW("dog3", '2012-01-01', 'dogs'),
    	ROW("cat1", '2010-01-01', 'cats'),
    	ROW("cat2", '2011-01-01', 'cats'),
    	ROW("cat3", '2012-01-01', 'cats'),
    	ROW("hamster1", '2010-01-01', 'hamsters'),
    	ROW("hamster2", '2011-01-01', 'hamsters'),
    	ROW("hamster3", '2012-01-01', 'hamsters');
```

Добавляем данные в таблицу pack_animals:

```sql
INSERT INTO pack_animals (name, birthdate, pack_animals.group)
VALUES 	ROW("horse1", '2010-01-01', 'horses'),
	ROW("horse2", '2011-01-01', 'horses'),
	ROW("horse3", '2012-01-01', 'horses'),
	ROW("camel1", '2010-01-01', 'camels'),
	ROW("camel2", '2011-01-01', 'camels'),
	ROW("camel3", '2012-01-01', 'camels'),
	ROW("donkey1", '2010-01-01', 'donkeys'),
	ROW("donkey2", '2011-01-01', 'donkeys'),
	ROW("donkey3", '2012-01-01', 'donkeys');
```

Добавляем данные в таблицу commands:

```sql

INSERT INTO commands(pet_id, command_name)
VALUES 	ROW(1, 'command1'),
	ROW(1, 'command2'),
	ROW(2, 'command1'),
	ROW(1, 'command3'),
	ROW(3, 'command3'),
	ROW(4, 'command1'),
	ROW(5, 'command4'),
	ROW(8, 'command5');

```

## Задание 10

Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
Объединить таблицы лошади, и ослы в одну таблицу.

### Решение

Удаляем из таблицы pack_animals всех верблюдов:

```sql

DELETE FROM pack_animals
WHERE pack_animals.group = "camels";

```

Так как вьючные животные находились в одной таблице, дополнительное объединение не нужно.

## Задание 11

Создать новую таблицу “Молодые животные”, в которую попадут все животные старше 1 года, но младше 3 лет
и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.

### Решение

Создаем новую временную таблицу. Добавляем вычисляемое поле, которое содержит возраст животного в месяцах. 

```sql

CREATE TEMPORARY TABLE young_animals
	SELECT id, pets.name, birthdate, pets.group, TIMESTAMPDIFF(month, birthdate, now()) AS age_months
    	FROM pets
	WHERE TIMESTAMPDIFF(month, birthdate, now()) >= 12
		AND TIMESTAMPDIFF(month, birthdate, now()) < 36
	UNION
    	SELECT id, pack_animals.name, birthdate, pack_animals.group, TIMESTAMPDIFF(month, birthdate, now()) AS age_months
    	FROM pets
	WHERE TIMESTAMPDIFF(month, birthdate, now()) >= 12
		AND TIMESTAMPDIFF(month, birthdate, now()) < 36;

```

## Задание 12

Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

### Решение

Создаем новую временую таблицу animals. Привязку к старой таблице реализуем посредством добавления поля с указанием имени родительской таблицы.

```sql

CREATE TEMPORARY TABLE animals
	SELECT id, pets.name, birthdate, pets.group, 'pets' AS parent_table
    	FROM pets
	UNION
    	SELECT id, pack_animals.name, birthdate, pack_animals.group, 'pack_animals' AS parent_table
    	FROM pack_animals;

```

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
