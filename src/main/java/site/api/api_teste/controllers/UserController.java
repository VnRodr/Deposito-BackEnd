package site.api.api_teste.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.api.api_teste.entities.User;
import site.api.api_teste.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() 
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) 
    {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        userService.saveEntity(user);
        URI location = URI.create("/api/create-user" + user.getId());
        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/update-user")
    public void atualizarEntidade(@RequestBody User user) {
        userService.changeEntity(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarEntidade(@PathVariable String id) {
        userService.deleteEntity(id);
    }
}
