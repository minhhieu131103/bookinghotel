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
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/userall")
    @CrossOrigin
    @ResponseBody
    public  List<User> getAllUsers() {
      // This returns a JSON or XML with the users
      return (List<User>) userRepository.findAll();
    }
    @GetMapping(path = "/userbyid/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {
      // This returns a JSON or XML with the users
      User u=userRepository.findById(id)
                                .orElse(new User());
      return (u);
    }

  //   @PostMapping("/themuser")
  //   @CrossOrigin
  // public void createUser(@RequestBody User u) {
  //   userRepository.save(u);
  // }

  //   @PostMapping("/xoauserbyid/{id}")
  //   @CrossOrigin
  // public void deleteUserById(@RequestBody User u) {
  //   Long id = u.getId();               
  //   userRepository.deleteById(id);
  // }

      @GetMapping(path = "/xoauserbyid/{id}")
      @ResponseBody
      public void deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}

