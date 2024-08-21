// Реализовать систему ввода данных пользователя
// Сохранять данные пользователя
// Выводить данные пользователя на экран
// Сделать минимально удобный интерфейс

package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        while(true) {
            app();
        }
    }

    private static void app() {
        System.out.print("Command:");
        Scanner scan = new Scanner(System.in);

        String cmd = scan.next();

        switch (cmd) {
            case "add": addUser(scan);
                break;
            case "list": getUsers();
                break;
            case "get": getUser(scan);
                break;
        }
    }

    private static void getUser(Scanner scan) {
        getUsers();
        System.out.println("Enter the user ID");

        try {
            Person person = persons.get(Integer.parseInt(scan.next())-1);
            System.out.println("Name: " + person.getName() + ", age: " + person.getAge());
            System.out.println("Created at: " + new Date(person.getCreatedAt()));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Person not found");
        } catch (NumberFormatException ex) {
            System.out.println("It's not Integer");
        }
    }

    private static void getUsers() {
        System.out.println("Data:");
        Integer personSize = persons.size();

        if (personSize <= 0) {
            System.out.println("Empty");
        }

        for (Integer i = 0; i < personSize; i++) {
            System.out.println(i+1 + ". " + persons.get(i).getName());
        }
    }

    private static void addUser(Scanner scan) {
        String name;
        int age;

        System.out.print("What's your name: ");
        name = scan.next();

        System.out.print("How old are you? ");
        try {
            age = Integer.parseInt(scan.next());
        } catch (NumberFormatException ex) {
            System.out.println("Ops. Age is number. ");
            return;
        }

        Person person = new Person(name, age);
        persons.add(person);
    }
}