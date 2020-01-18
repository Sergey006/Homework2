package com.sergey;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        //fileName = "source.txt"
        String fileName = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
            Scanner scanner = null;
            try {
                int maxCount = 0;
                scanner = new Scanner(new File(fileName));
                scanner.useDelimiter("[^a-zA-Zа-яА-Я]+");
                while (scanner.hasNext()){
                    String word = scanner.next().toLowerCase();
                    Integer count = map.get(word);
                    if (count == null){
                        count = 0;
                    }
                    map.put(word, ++count);
                    if (count > maxCount){
                        maxCount = count;
                    }
                }
                System.out.println("-----\nПолный список найдённых слов:");
                for (Map.Entry<String, Integer> entry:map.entrySet()){
                    System.out.println(entry.getKey() + " = " + entry.getValue() + " раз(а)");
                }
                System.out.println("-----\nНаибольшее количество раз встречается слово:");
                for (Map.Entry<String, Integer> entry:map.entrySet()){
                    if (entry.getValue() == maxCount){
                        System.out.println(entry + " раз(а)");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
