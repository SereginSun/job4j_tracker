package ru.job4j.ex;

public class JdbcConfig {
    public static void load(String url) throws UserInputException {
        if (url == null) {
            throw new UserInputException("URL could not be null.");
        }
        /* Load JDBC */
    }

    public static void main(String[] args) {
        try {
            load("jdbc://localhost:8080");
        } catch (UserInputException uie) {
            uie.printStackTrace();
        }
    }
}
