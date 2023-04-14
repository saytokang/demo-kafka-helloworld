package com.example.demokafkahelloworld.jsonSer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> registUser(@RequestParam long id, @RequestParam("name") String name) {
        User user = User.builder().id(id).name(name).build();
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
}
