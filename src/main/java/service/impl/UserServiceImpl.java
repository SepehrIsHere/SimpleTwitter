package service.impl;

import entities.User;
import repository.UserRepository;
import service.UserService;

import java.util.List;

public class UserServiceImpl<T extends User> implements UserService<T> {
    private final UserRepository<T> repository;

    public UserServiceImpl(UserRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(T user) {
        try {
            repository.addUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(T user) {
        try {
            repository.update(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(T user) {
        try {
            repository.removeUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getUsers() {
        return repository.findAll();
    }

    @Override
    public T getUserById(Long id) {
        if (repository.contains(repository.findById(id))) {
            return repository.findById(id);
        }
        return null;
    }

    @Override
    public T getUserByUsername(String username) {
        if (repository.contains(repository.findByUsername(username))) {
            return repository.findByUsername(username);
        }
        return null;
    }

    @Override
    public T getUserByEmail(String email) {
        if (repository.contains(repository.findByEmail(email))) {
            return repository.findByEmail(email);
        }
        return null;
    }
}
