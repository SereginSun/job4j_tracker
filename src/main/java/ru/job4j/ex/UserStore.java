package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User wantedUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                wantedUser = user;
                break;
            }
        }
        if (wantedUser == null) {
            throw new UserNotFoundException("No user with this nickname was found.");
        }
        return wantedUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 4) {
            throw new UserInvalidException(
                    "The user does not have access or the length of the nickname is less than 3 characters."
            );
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Vladimir Seregin", false)
        };
        try {
            User user = findUser(users, "Vladimir Seregin");
            if (validate(user)) {
                System.out.println("This user has an access.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
