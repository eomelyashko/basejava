package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/ru/javawebinar/basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

        //recursive output of file names
        findFiles(dir);
    }

    public static void findFiles(File file) throws IOException {
        if (file.isDirectory()) {
            System.out.println(file.getName());
            File[] list = file.listFiles();
            if (list != null) {
                for (int i = list.length; --i >= 0; ) {
                    findFiles(list[i]);
                }
            }
        } else {
            System.out.println("\t" + file.getCanonicalPath());
        }
    }
}
