package repository.impl;

import entities.Tweet;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.TweetRepository;
import util.TransactionUtil;

import java.util.List;

public class TweetRepositoryImpl<T> implements TweetRepository<Tweet>, TransactionUtil {
    protected final EntityManager em;

    public TweetRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addTweet(Tweet entity) {
        beginTransaction();
        em.persist(entity);
        commitTransaction();
    }

    @Override
    public void update(Tweet entity) {
        beginTransaction();
        em.merge(entity);
        commitTransaction();
    }

    @Override
    public void removeTweet(Tweet entity) {
        beginTransaction();
        em.remove(entity);
        commitTransaction();
    }

    @Override
    public List<Tweet> findAll() {
        return em.createQuery("from Tweet", Tweet.class).getResultList();
    }

    @Override
    public Tweet findById(Long id) {
        return em.find(Tweet.class, id);
    }

    @Override
    public Tweet findByText(String text) {
        return em.find(Tweet.class, text);
    }

    @Override
    public boolean contains(Tweet entity) {
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
