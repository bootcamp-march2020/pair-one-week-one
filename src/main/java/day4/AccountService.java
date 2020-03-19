package day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Boolean canReadSalaryDetails(User user) {
        return accountRepository.canReadSalaryDetails(user);
    }

    public Boolean canReadSalaryDetailsWithDomain(User user) {
        return accountRepository.getUserAccount(user).canReadSalaryDetails();
    }
}

class AccountRepository {

    public Account getUserAccount(User user) {
        Map<String, User> users = new HashMap<String, User>();
        users.put("a@a.com", new User("a@a.com"));
        users.put("b@b.com", new User("b@b.com"));
        return (Account) users.get(user.getEmail());
    }

    public Boolean canReadSalaryDetails(User user) {
        // connect to DB
        // fetch user
        // get account details
        // return if can read salary details
        return false;
    }
}

class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

interface Account {
    Boolean canReadSalaryDetails();
}

class UserAccount implements Account {

    @Override
    public Boolean canReadSalaryDetails() {
        return false;
    }
}

class AdminAccount implements Account {

    @Override
    public Boolean canReadSalaryDetails() {
        return true;
    }
}