package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.User;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final HashMap<Long, User> users = new HashMap<>();

    public UserService() {
        users.put(1L, new User(1L, "ondrej@upce.cz", "Pass123"));
        users.put(2L, new User(2L, "tomas@upce.cz", "ABC123"));
    }

    public Collection<User> geAllUsers(){
        return users.values();
    }

    public String findUser() {
        User user = users.get(1L);
        if (user != null) {
            log.info("User requested: " + user);
            return user.toString();
        } else {
            log.warn("User not found.");
            return "User not found.";
        }
    }

    public User findById(Long id) {
        return users.get(id);
    }
}
