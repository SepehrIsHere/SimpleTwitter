package repository;

import entities.Tweet;

import java.util.List;

public interface TweetRepository<T extends Tweet> {
    void addTweet(T entity);

    void update(T entity);

    void removeTweet(T entity);

    List<T> findAll();

    T findById(Long id);

    T findByText(String text);

    boolean contains(T entity);
}
