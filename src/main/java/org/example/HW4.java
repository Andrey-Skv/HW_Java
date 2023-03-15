package org.example;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class HW4 {
    public static void main(String[] args) {
        //1. Реализовать консольное приложение, которое:
//        Принимает от пользователя и “запоминает” строки.
//        Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//        Если введено revert, удаляет предыдущую введенную строку из памяти.
        System.out.println("Java HW4. Task1 - actionsWithString");
  //      actionsWithString();
//        2. Пусть дан LinkedList с несколькими элементами.
//        Реализуйте метод, который вернет “перевернутый” список.
        System.out.println("Java HW4. Task2 - reverseList");
        LinkedList<String> list = new LinkedList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        System.out.println(list);
        System.out.println(reverseLinkedList(list));
    }

    public static LinkedList reverseLinkedList(LinkedList list) {
        LinkedList reversedList = new LinkedList();
        for(int i=list.size()-1; i>=0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;

    }


    private static void actionsWithString() {

            Scanner scanner = new Scanner(System.in);
            ArrayList<String> list = new ArrayList<>();
            while (true) {
                System.out.print("Введите строку: ");
                String input = scanner.nextLine();
                if (input.equals("print")) {
                    System.out.println("Введенные строки: ");
                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.println(list.get(i));
                    }
                } else if (input.equals("revert")) {
                    if (list.size() > 0) {
                        list.remove(list.size() - 1);
                        System.out.println("Предыдущая строка удалена из памяти.");
                    } else {
                        System.out.println("Память пуста.");
                    }
                } else {
                    list.add(input);
                }
            }
        }
    }
