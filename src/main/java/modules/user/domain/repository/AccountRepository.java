package modules.user.domain.repository;

import modules.user.domain.Account;

public interface AccountRepository {

//    public boolean validateAccount(String accountid) {
//        return true;
//    }
    public boolean validateAccount(String accountId);
    public void save(Account account);

}