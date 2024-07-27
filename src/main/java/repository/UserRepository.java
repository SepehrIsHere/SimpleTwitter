package repository;

import entities.User;

import java.util.List;

public interface UserRepository<T extends User> {
    void addUser(T entity);

    void update(T entity);

    void removeUser(T entity);

    List<T> findAll();

    T findById(Long id);

    T findByUsername(String username);

    T findByEmail(String email);

    boolean contains(T entity);
}
