package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> name = readFile("students.txt");
        ArrayList<String> questions = readFile("questions.txt");



    }

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
