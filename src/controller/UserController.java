package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.Privacy;
import model.User;
import model.UserBuilder;

public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    // NOTE: Factory
    // NOTE: Builder
    public User createUser(String name, String email, String password, Privacy privacy) {
        User user = new UserBuilder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setPrivacy(privacy)
                .build();
        users.add(user);
        return user;
    }

    public boolean editUser(UUID id, String name, String email, String password, Privacy privacy) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setPrivacy(privacy);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User getUserById(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
