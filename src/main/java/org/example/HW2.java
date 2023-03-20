package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

    public class HW2 {
        public static void main(String[] args) throws IOException {

            //1. Создать метод, который проверяет, является ли строка палиндромом.
            //Палиндром - шалаш
            Scanner in = new Scanner(System.in);
            System.out.println("Java HW2. Task 1 - isPalindrome");
            System.out.print("Enter word: ");
            String value = in.next();
            String result = isPalindrome(value) ? " is a palindrome." : " is not a palindrome.";
            System.out.println("Word " + value + result);
            in.close();


            // 2. С помощью Java создать файл file.txt, и записать в него слово TEST 100 раз.
            // Если уже файл создан, то перезаписываем его.
            System.out.println("Java HW2. Task 2 - print TEST");
            Path file = Path.of("file.txt");

            try {
                Files.createFile(file);
                Files.writeString(file, wordsGenerator("TEST", 100));
                if (Files.exists(file)) System.out.println("File has been created");
            } catch (IOException ex) {
                Files.writeString(file, wordsGenerator("TEST", 100));
                System.out.println("File has been already exist and was rewritten");
            }

//            3*.Напишите метод, который определит тип
//            (расширение) файлов из текущей папки и выведет в консоль результат
            System.out.println("Java HW3. Task 3 - getFileExtension");
            File folder = new File(".");
            File[] files = folder.listFiles();
            int count = 0;
            for (File fil : files) {
                if (fil.isFile()) {
                    String extension = getFileExtension(fil.getName());
                    System.out.println(++count + " Расширение файла: " + extension);
                }
            }
        }

        private static String getFileExtension(String fileName) {
            int index = fileName.lastIndexOf('.');
            if (index > 0) {
                return fileName.substring(index + 1);
            } else {
                return "";
            }
        }



        public static boolean isPalindrome(String word) {
            StringBuffer strBuffer = new StringBuffer(word);
            return (word.equals(strBuffer.reverse().toString()));
        }

        public static String wordsGenerator(String value, int quantity) {
            StringBuilder creator = new StringBuilder();
            for (int i = 0; i < quantity; i++) {
                creator.append(value).append("\n");
            }
            return creator.toString();
        }


    }