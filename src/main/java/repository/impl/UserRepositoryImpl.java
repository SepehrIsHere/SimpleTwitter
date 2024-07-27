package repository.impl;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.UserRepository;
import util.TransactionUtil;

import java.util.List;

public class UserRepositoryImpl<T> implements UserRepository<User>, TransactionUtil {
    protected EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addUser(User entity) {
        beginTransaction();
        em.persist(entity);
        commitTransaction();
    }

    @Override
    public void update(User entity) {
        beginTransaction();
        em.merge(entity);
        commitTransaction();
    }

    @Override
    public void removeUser(User entity) {
        beginTransaction();
        em.remove(entity);
        commitTransaction();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return em.find(User.class, username);
    }

    @Override
    public User findByEmail(String email) {
        return em.find(User.class, email);
    }

    @Override
    public boolean contains(User entity) {
        return em.contains(entity);
    }

    @Override
    public void beginTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }

    @Override
    public void commitTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive() && !transaction.getRollbackOnly()) {
            transaction.commit();
        }
    }

    @Override
    public void rollbackTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

}
