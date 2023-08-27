package com.example.StudentServices.Service;

import java.util.Random;

public class RandomService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int MIN_NUMBER = 10000;
    private static final int MAX_NUMBER = 99999;

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomString.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return randomString.toString();
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    public static String generateCombo(int length) {
        String randomString = generateRandomString(length); // 5-character string
        int randomNum = generateRandomNumber();
        return randomString + randomNum; // String first, then number
    }

}
