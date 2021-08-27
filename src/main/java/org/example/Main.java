package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = getString();
        writeToFile(text);



    }

    //Закрытый метод который генерирует случайным образом вопросы каждого студенту
    private static String getString() {
        Random random = new Random();
        ArrayList<String> name = readFile("students.txt");
        ArrayList<String> questions = readFile("questions.txt");

        String[] arrText = new String[name.size()];
        for (int i = 0; i < name.size(); i++) {
            int indexQuestionsRandom = random.nextInt(questions.size());
            arrText[i] = (name.get(i) + " " + questions.get(indexQuestionsRandom) + "\n");
        }
        String text = Arrays.stream(arrText).reduce((x, x1) -> x + "" + x1).get();
        return text;
    }


    //метода для написания файла сегодняшних вопросом
    public static void writeToFile(String text) {
        LocalDateTime ldt = LocalDateTime.now();
        String time = ldt.format(DateTimeFormatter.ISO_DATE);
        String file = String.format("questions-%s.txt", time);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метода для чтения файлов
    public static ArrayList<String> readFile(String file) {
        ArrayList<String> buf = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String buffer = null;
            while ((buffer = bufferedReader.readLine()) != null) {
                buf.add(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }
}
