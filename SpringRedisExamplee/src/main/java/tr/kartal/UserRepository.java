package tr.kartal;

import java.util.Map;

import tr.kartal.model.User;

public interface UserRepository {

    void save(User user);
    Map<String, User> findAll();
    User findById(String id);

}
