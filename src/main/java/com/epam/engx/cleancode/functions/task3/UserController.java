package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.exceptions.UserNotFoundException;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;

import java.util.Optional;

public abstract class UserController implements Controller {

    private UserAuthenticatorService userAuthenticator;

    public void authenticateUser(String userName, String password) {
        Optional<User> userOptional = Optional.empty();
        try {
            userOptional = Optional.ofNullable(userAuthenticator.login(userName, password));
        } catch (UserNotFoundException e) {
            generateFailLoginResponse();
        }

        if (userOptional.isPresent()) {
            generateSuccessLoginResponse(userName);
        }

    }

    public void setUserAuthenticator(UserAuthenticatorService userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
