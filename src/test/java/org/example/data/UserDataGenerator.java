package org.example.data;

import java.util.UUID;

public class UserDataGenerator {

    public static String generateUniqueEmail() {
        return "qa_" + UUID.randomUUID().toString().substring(0, 8) + "@test.ru";
    }

    public static String generatePassword() {
        return "Test12345!";
    }
}
