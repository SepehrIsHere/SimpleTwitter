package service;

import entities.Tweet;

import java.util.List;

public interface TweetService<T extends Tweet> {
    void addTweet(T tweet);

    void removeTweet(T tweet);

    void updateTweet(T tweet);

    List<T> getTweets();

    T getTweetById(Long id);
}
