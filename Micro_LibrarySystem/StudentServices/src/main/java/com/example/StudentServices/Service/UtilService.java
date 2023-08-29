package com.example.StudentServices.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class UtilService {


    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int MIN_NUMBER = 0; // Start with 0 to include 0 in the random numbers
    private static final int MAX_NUMBER = 9; // End with 9 for single-digit random numbers

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                randomString.append(CHARACTERS.toUpperCase().charAt(random.nextInt(CHARACTERS.length())));
            } else {
                randomString.append(random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER);
            }
        }
        return randomString.toString();
    }
    public static void createDirectoryIfNeeded() {
        String directoryPath = "/home/blue/LBMS/Users"; // Update this path
        Path path = Paths.get(directoryPath);

        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                System.out.println("Directory created: " + directoryPath);
            } catch (IOException e) {
                System.err.println("Error creating directory: " + e.getMessage());
            }
        }
    }
}
