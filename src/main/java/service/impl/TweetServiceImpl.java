package service.impl;

import entities.Tweet;
import repository.TweetRepository;
import service.TweetService;

import java.util.List;

public class TweetServiceImpl<T extends Tweet> implements TweetService<T> {
    private final TweetRepository<T> tweetRepository;

    public TweetServiceImpl(TweetRepository<T> tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public void addTweet(T tweet) {
        try {
            tweetRepository.addTweet(tweet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeTweet(T tweet) {
        try {
            tweetRepository.removeTweet(tweet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateTweet(T tweet) {
        try {
            tweetRepository.update(tweet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getTweets() {
        return tweetRepository.findAll();
    }

    @Override
    public T getTweetById(Long id) {
        if (tweetRepository.contains(tweetRepository.findById(id))) {
            return tweetRepository.findById(id);
        }
        return null;
    }
}
