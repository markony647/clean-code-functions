package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.exceptions.UserNotFoundException;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;

public abstract class UserController implements Controller {

    private UserAuthenticatorService userAuthenticator;

    public void authenticateUser(String userName, String password) {
        User user = null;
        try {
            user = userAuthenticator.login(userName, password);
        } catch (UserNotFoundException e) {
            generateFailLoginResponse();
        }

        if (user != null) {
            generateSuccessLoginResponse(userName);
        }
    }

    public void setUserAuthenticator(UserAuthenticatorService userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
