package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {

    private static final int MIN_REQUIRED_NAME_LENGTH = 6;
    private static final int MIN_REQUIRED_PASSWORD_LENGTH = 9;

    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        validate(account);
        initialize(account);
        create(account);
    }

    private void create(Account account) {
        accountManager.createNewAccount(account);
    }

    private void initialize(Account account) {
        account.setCreatedDate(new Date());
        account.setAddresses(getAllAssociatedAddresses(account));
    }

    private List<Address> getAllAssociatedAddresses(Account account) {
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        return addresses;
    }

    private void validate(Account account) {
        validateName(account.getName());
        validatePassword(account.getPassword());
    }

    private void validateName(String name) {
        if (hasValidName(name)) {
            throw new WrongAccountNameException();
        }
    }

    private boolean hasValidName(String name) {
        return name.length() < MIN_REQUIRED_NAME_LENGTH;
    }

    private void validatePassword(String password) {
        validatePasswordLength(password);
        validatePasswordStatus(password);
    }

    private void validatePasswordStatus(String password) {
        if (isNotOk(password)) {
            throw new WrongPasswordException();
        }
    }

    private boolean isNotOk(String password) {
        return passwordChecker.validate(password) != OK;
    }

    private void validatePasswordLength(String password) {
        if (hasNotAcceptedLength(password)) {
            throw new TooShortPasswordException();
        }
    }

    private boolean hasNotAcceptedLength(String password) {
        return password.length() < MIN_REQUIRED_PASSWORD_LENGTH;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }
}
