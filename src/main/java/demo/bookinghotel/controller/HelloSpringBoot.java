package demo.bookinghotel.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.bookinghotel.repository.UserRepository;
import demo.bookinghotel.models.User;

@RestController
public class HelloSpringBoot {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path = "/all")
    @CrossOrigin
    @ResponseBody
    public  List<User> getAllUsers() {
      // This returns a JSON or XML with the users
      return (List<User>) userRepository.findAll();
    }
    @GetMapping(path = "/byid/{id}")
    @ResponseBody
    public User getByName(@PathVariable String name) {
      // This returns a JSON or XML with the users
      User u=userRepository.findByName(name)
                                .orElse(new User());
      return (u);
    }

    @PostMapping("/themuser")
    @CrossOrigin
  public void createUser(@RequestBody User u) {
    userRepository.save(u);
  }

}

