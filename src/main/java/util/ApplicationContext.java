package util;

import entities.Tweet;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.TweetRepository;
import repository.UserRepository;
import repository.impl.TweetRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.TweetService;
import service.UserService;
import service.impl.TweetServiceImpl;
import service.impl.UserServiceImpl;

public class ApplicationContext {
    private static ApplicationContext instance;
    private EntityManagerFactory emf;
    private EntityManager em;
    private TweetRepository<Tweet> tweetRepository;
    private UserRepository<User> userRepository;
    private UserService<User> userService;
    private TweetService<Tweet> tweetService;

    private ApplicationContext() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        userRepository = new UserRepositoryImpl<User>(instance.getEntityManager());
        tweetRepository = new TweetRepositoryImpl<Tweet>(instance.getEntityManager());
        userService = new UserServiceImpl<User>(userRepository);
        tweetService = new TweetServiceImpl<Tweet>(tweetRepository);
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = getEntityManagerFactory().createEntityManager();
        }
        return em;
    }


}
