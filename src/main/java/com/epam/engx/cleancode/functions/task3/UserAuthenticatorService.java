package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.exceptions.WrongPasswordException;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.SessionManager;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.UserService;

public abstract class UserAuthenticatorService implements UserService {

    private SessionManager sessionManager;

    public void login(String userName, String password) {
        loginUser(getUserByName(userName), password);
    }

    private void loginUser(User user, String password) {
        if (isPasswordCorrect(user, password)) {
            sessionManager.setCurrentUser(user);
            return;
        }
        throw new WrongPasswordException();
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
