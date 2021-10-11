package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.exceptions.WrongPasswordException;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;

public abstract class UserController implements Controller {

    private UserAuthenticatorService userAuthenticator;

    public void authenticateUser(String userName, String password) {
        try {
            userAuthenticator.login(userName, password);
            generateSuccessLoginResponse(userName);
        } catch (WrongPasswordException e) {
            generateFailLoginResponse();
        }
    }

    public void setUserAuthenticator(UserAuthenticatorService userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
