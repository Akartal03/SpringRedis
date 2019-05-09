package tr.kartal;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.kartal.model.User;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        userRepository.save(new User(id, name));
        return userRepository.findById(id);
    }



    @GetMapping("/all")
    public Map<String, User> all() {
        return userRepository.findAll();
    }
}
