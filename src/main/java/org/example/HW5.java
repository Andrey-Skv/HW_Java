package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class HW5 {
    public static void main(String[] args) {
//        1. Реализуйте структуру телефонной книги с помощью HashMap,
//                учитывая, что 1 человек может иметь несколько телефонов.
        System.out.println("Java HW5. Task1 - phoneBooks");
//        phoneBooks();
//        2. Пусть дан список сотрудников:
//        Иван Иванов
//
//        Светлана Петрова
//
//        Кристина Белова
//
//        Анна Мусина
//
//        Анна Крутова
//
//        Иван Юрин
//
//        Петр Лыков
//
//        Павел Чернов
//
//        Петр Чернышов
//
//        Мария Федорова
//
//        Марина Светлова
//
//        Мария Савина
//
//        Мария Рыкова
//
//        Марина Лугова
//
//        Анна Владимирова
//
//        Иван Мечников
//
//        Петр Петин
//
//        Иван Ежов
//
//        Написать программу, которая найдёт и выведет повторяющиеся
//        имена с количеством повторений. Отсортировать по убыванию популярности.
        System.out.println("Java HW5. Task2 - findRepeatNames");
        findRepeatNames();

    }

    private static void findRepeatNames() {
        String[] employees = {"Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков",
                "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов"};

        Map<String, Integer> nameCountMap = new HashMap<>();


        for (String employee : employees) {
            String firstName = employee.split(" ")[0];
            nameCountMap.put(firstName, nameCountMap.getOrDefault(firstName, 0) + 1);
        }


        String[] sortedNames = nameCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toArray(String[]::new);


        for (String firstName : sortedNames) {
            int count = nameCountMap.get(firstName);
            if (count > 1) {
                System.out.println(firstName + ": " + count);
            }
        }
    }


    private static void phoneBooks() {
            HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
            Scanner scanner = new Scanner(System.in);


            while (true) {
                System.out.println("Введите команду (add или find):");
                String command = scanner.nextLine();

                if (command.equals("add")) {
                    System.out.println("Введите фамилию:");
                    String lastName = scanner.nextLine().toLowerCase();

                    if (!phoneBook.containsKey(lastName)) {
                        phoneBook.put(lastName, new ArrayList<>());
                    }

                    System.out.println("Введите телефон:");
                    String phone = scanner.nextLine();
                    phoneBook.get(lastName).add(phone);
                } else if (command.equals("find")) {
                    System.out.println("Введите фамилию:");
                    String lastName = scanner.nextLine().toLowerCase();

                    if (phoneBook.containsKey(lastName)) {
                        ArrayList<String> phones = phoneBook.get(lastName);

                        if (phones.size() == 1) {
                            System.out.println("Телефон: " + phones.get(0));
                        } else {
                            System.out.println("Телефоны: ");

                            for (String phone : phones) {
                                System.out.println(phone);
                            }
                        }
                    } else {
                        System.out.println("Такой фамилии нет в телефонной книге");
                    }
                } else {
                    System.out.println("Неверная команда");
                }
            }
        }
        }