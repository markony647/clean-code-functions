package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {

    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        Date now = new Date();
        validateAccount(account);
        account.setCreatedDate(now);
        account.setAddresses(getAllAssociatedAddresses(account));

        accountManager.createNewAccount(account);
    }

    private List<Address> getAllAssociatedAddresses(Account account) {
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        return addresses;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

    private void validateAccount(Account account) {
        validateName(account.getName());
        validatePassword(account.getPassword());
    }

    private void validateName(String name) {
        int minimumRequiredNameLength = 5;
        if (name.length() <= minimumRequiredNameLength) {
            throw new WrongAccountNameException();
        }
    }

    private void validatePassword(String password) {
        validatePasswordLength(password);
        validatePasswordStatus(password);
    }

    private void validatePasswordStatus(String password) {
        if (passwordChecker.validate(password) != OK) {
            throw new WrongPasswordException();
        }
    }

    private void validatePasswordLength(String password) {
        int minimumRequiredPasswordLength = 8;
        if (password.length() <= minimumRequiredPasswordLength) {
            throw new TooShortPasswordException();
        }
    }
}
