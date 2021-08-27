package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main{
    public static void main(String[] args) {
        readFile();

    }
    public static void readFile(){
        try {
            FileInputStream fis = new FileInputStream("questions.txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            int i;
            while ((i = isr.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
