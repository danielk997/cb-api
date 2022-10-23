package com.example.sample.web;

import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.User;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

class UserDTO {
    String email;
    String firstName;
    String lastName;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}

@RestController
public class AdminController {
    @Autowired
    public Client client;

    @GetMapping("/users")
    public UserList getUsers() {
        return client.listUsers();
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        Double x = Math.random();
        Integer a = userDTO.email.length();
        Double result = Math.log(a/x);
        String tempPassword = result.toString();

        User user = UserBuilder.instance()
                .setEmail(userDTO.getEmail())
                .setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName())
                .setPassword(tempPassword.toCharArray())
                .setActive(true)
                .buildAndCreate(client);

        String body = "{\"password\":\"" + tempPassword + "\"}";

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}