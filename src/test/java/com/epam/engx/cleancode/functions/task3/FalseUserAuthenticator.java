package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;

class FalseUserAuthenticator extends UserAuthenticatorService {
    @Override
    public boolean isPasswordCorrect(User user, String password) {
        return false;
    }

    @Override
    public User getUserByName(String userName) {
        return new User() {};
    }
}
