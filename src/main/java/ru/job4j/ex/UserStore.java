package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User name : users) {
            if (login.equals(name.getUsername())) {
                user = name;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("user is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true), new User("Se", true),
        new User("Ivan Ivanov", false)};
        try {
            User user = findUser(users, "Ivan Ivanov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
