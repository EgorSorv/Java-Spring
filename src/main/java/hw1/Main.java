package hw1;

import hw1.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static hw1.services.JsonManagement.deserialization;
import static hw1.services.JsonManagement.serialization;

/**
 * Домашнее задание <p>
 * Условие: <p>
 * Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код,
 * использующий эти зависимости. <p>
 * Пример решения: <p>
 * 1. Создайте новый Maven или Gradle проект, через Intellij IDEA. <p>
 * 2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0 и com.google.code.gson:gson:2.10.1. <p>
 * 3. Создайте класс Person с полями firstName, lastName и age. <p>
 * 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode. <p>
 * 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON. <p>
 */

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(); // список Person
        fillPersonList(persons);

        System.out.println("Сериализация списка людей в формат JSON:");
        String json = serialization(persons); // строка JSON
        System.out.println(json + "\n");

        System.out.println("Десериализация списка людей из формата JSON:");
        List<Person> finalList = deserialization(json); // преобразованный из JSON список Person
        printPersonList(finalList);
    }

    // автозаполнение списка Person
    private static void fillPersonList(List<Person> persons) {
        for (int i = 1; i <= 10; i++)
            persons.add(new Person("Name №" + i, "Surname №" + i,
                    new Random().nextInt(18, 50)));
    }

    // печать списка Person
    private static void printPersonList(List<Person> persons) {
        for (Person person: persons)
            System.out.println(person);
    }
}
