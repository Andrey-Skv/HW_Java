package org.example;

import java.util.*;
import java.time.LocalDateTime;

public class HW1 {
    public static void main(String[] args) {
        System.out.println("Hello Игорь!");
        maxAndMinValue();
        helloTimeOfDay();
        sortArray();
    }

    //    Задать одномерный массив и найти в нем минимальный и максимальный элементы
    public static void maxAndMinValue() {
        int sizeArray = 10; // Длина массива
        int[] rndArray = createRandomArray(sizeArray);
        System.out.println("В массиве " + Arrays.toString(rndArray) +
                " минимальный элемент: " + getMinValue(rndArray) + ", а " +
                " максимальный элемент: " + getMaxValue(rndArray) + ".");
    }


    private static int[] createRandomArray(int lenArray) {
        Random r = new Random();
        int[] rndArray = new int[lenArray];
        for (int i = 0; i < rndArray.length; i++) {
            rndArray[i] = r.nextInt(10, 100);
        }
        return rndArray;
    }

    private static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) maxValue = array[i];
        }
        return maxValue;
    }

    private static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) minValue = array[i];
        }
        return minValue;
    }

    //В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
    //"Доброе утро, <Имя>!", если время от 05:00 до 11:59
    //"Добрый день, <Имя>!", если время от 12:00 до 17:59;
    //"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    //"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    public static void helloTimeOfDay() {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите имя :");
        String name = iScanner.nextLine();
        iScanner.close();
        LocalDateTime current = LocalDateTime.now();
        int time = current.getHour();
        if (time >= 5 && time < 12) {
            System.out.printf("Доброе утро, %s!", name);
        } else if (time >= 12 && time < 18) {
            System.out.printf("Добрый день, %s!", name);
        } else if (time >= 18 && time < 23) {
            System.out.printf("Добрый вечер, %s!", name);
        } else if (time >= 23 && time < 5) {
            System.out.printf("Доброй ночи, %s!", name);
        }

    }
    // Дан массив nums = [3,2,2,3] и число val = 3.
    //Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
    //Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

        public static void sortArray() {
            int[] nums = new int[]{3, 2, 2, 3, 2, 3, 2, 3, 5, 6};
            int val = 3;

            // Оставим только элементы в массиве, значения которых не равны заданному
            List<Integer> filteredNums = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    filteredNums.add(nums[i]);
                }
            }
            System.out.println(filteredNums);

            // Посчитаем количество элементов, значения которых равны заданному
            int count = nums.length - filteredNums.size();

            // Добавим в конец массива столько элементов, сколько нам нужно
            for (int i = 0; i < count; i++) {
                filteredNums.add(val);
            }

            // Печатаем отфильтрованный массив
            for (int i = 0; i < filteredNums.size(); i++) {
                System.out.print(filteredNums.get(i) + " ");
            }
            System.out.println();
        }
    }

