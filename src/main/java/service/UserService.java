package service;

import entities.User;

import java.util.List;

public interface UserService<T extends User> {
    void addUser(T user);

    void updateUser(T user);

    void deleteUser(T user);

    List<T> getUsers();

    T getUserById(Long id);

    T getUserByUsername(String username);

    T getUserByEmail(String email);
}
