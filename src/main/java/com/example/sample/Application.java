package com.example.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @RestController
    static class SimpleRestController {
        @GetMapping("/")
        ResponseEntity<String> sayHello(@AuthenticationPrincipal OidcUser oidcUser) {
//            if (oidcUser == null) {
//                return ResponseEntity
//                        .status(HttpStatus.UNAUTHORIZED)
//                        .body("User is unauthenticated");
//            }


            return new ResponseEntity<>("Hello: " + oidcUser.getFullName(), HttpStatus.OK);
        }
    }

}
