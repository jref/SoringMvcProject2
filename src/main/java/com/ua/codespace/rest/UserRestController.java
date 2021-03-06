package com.ua.codespace.rest;

import com.ua.codespace.entity.User;
import com.ua.codespace.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @RequestMapping("/{username}")
    public User get(@PathVariable String username) {
        if (username.length() < 4) {
            throw new UserNotFoundException(username);
        } else {
            return new User(username);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        System.out.println(user.getUsername());
    }
}
