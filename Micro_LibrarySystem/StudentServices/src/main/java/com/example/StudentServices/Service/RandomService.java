package com.example.StudentServices.Service;

import java.util.Random;

public class RandomService {


    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int MIN_NUMBER = 0; // Start with 0 to include 0 in the random numbers
    private static final int MAX_NUMBER = 9; // End with 9 for single-digit random numbers

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                // The first character should be a capital letter
                randomString.append(CHARACTERS.toUpperCase().charAt(random.nextInt(CHARACTERS.length())));
            } else {
                // The rest of the characters should be random numbers
                randomString.append(random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER);
            }
        }

        return randomString.toString();
    }
}
