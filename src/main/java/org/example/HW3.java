package org.example;

import java.util.*;

public class HW3 {
    public static void main(String[] args) {
        //    1. Пусть дан произвольный список целых чисел,
//    удалить из него четные числа (в языке уже есть что-то готовое для этого)
        System.out.println("Java HW3. Task 1 - deleteEvenNum ");
        deleteEvenNum();
        //    2. Задан целочисленный список ArrayList.
//    Найти минимальное, максимальное и среднее арифметическое из этого списка.
        System.out.println("Java HW3. Task 2 - findMinMaxAverage ");
        findMinMaxAverage();
//        3. Создать список типа ArrayList<String>.
//        Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
        System.out.println("Java HW3. Task 3 - deleteInteger ");
        deleteInteger();
    }

    private static void deleteInteger() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("world");
        list.add("!");
        list.add("123");
        list.add("456");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("\\d+")) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);

    }



    private static void findMinMaxAverage() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            int n = (int) ((Math.random() * (60 - 0)) + 0);
            list.add(n);
        }
        System.out.println(list);
        int min = list.get(0);
        int max = list.get(0);
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }

            sum += num;
        }

        double average = (double) sum / list.size();
        System.out.println("Maximum is : " + max);
        System.out.println("Minimum is : " + min);
        System.out.println("Average is : " + average);
//        То же самое с помощью встроенного класса


//        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//        IntSummaryStatistics stats = primes.stream()
//                .mapToInt((x) -> x)
//                .summaryStatistics();
//        System.out.println(stats);
    }


    private static void deleteEvenNum() {
    List<Integer> num = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            int n = (int) ((Math.random() * (60 - 0)) + 0);
            num.add(n);
        }
        System.out.println(num);
        for (Iterator<Integer> iterator = num.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                System.out.println("This is Even Number: " + number);
                iterator.remove();
            }

        }

        Collections.sort(num);
        System.out.println("Sorted List: " + num);
    }
}
