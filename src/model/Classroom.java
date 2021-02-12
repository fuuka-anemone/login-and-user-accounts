package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<UserAccount> accounts;

    public Classroom() {
        this.accounts = new ArrayList<>();
    }

    public List<UserAccount> getAccounts() {
        return accounts;
    }
}
