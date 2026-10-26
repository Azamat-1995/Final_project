package org.example.data;

import java.util.UUID;

/**
 * Централизованная генерация тестовых данных для пользователей.
 */
public class UserDataGenerator {

    public static String generateUniqueEmail() {
        return "qa_" + UUID.randomUUID().toString().substring(0, 8) + "@test.ru";
    }

    public static String generatePassword() {
        return "Test12345!";
    }

    public static String generateListingTitle() {
        return "Тестовое объявление " + UUID.randomUUID().toString().substring(0, 8);
    }
}