package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.exceptions.UserNotFoundException;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;

public abstract class UserController implements Controller {

    private UserAuthenticatorService userAuthenticator;

    public void authenticateUser(String userName, String password) {
        try {
            userAuthenticator.login(userName, password);
        } catch (UserNotFoundException e) {
            generateFailLoginResponse();
        }
        generateSuccessLoginResponse(userName);
    }

    public void setUserAuthenticator(UserAuthenticatorService userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
