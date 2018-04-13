package com.soconnorpact.client;

import com.soconnorpact.provider.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class UserPreferenceService {


    @GetMapping("/user/preference")
    public UserPreferences retrieveUserPreference() {
        final UserPreferences userPreferences = new UserPreferences();

        RestTemplate restTemplate = new RestTemplate();
        final User user = restTemplate.getForObject("http://localhost:8080/user", User.class);

        userPreferences.setUserName(user.getUserName());
        userPreferences.setUserId("1");
        userPreferences.setPreferences(Collections.singletonList("Stuff"));

        return userPreferences;
    }
}
