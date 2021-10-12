package modules.account.domain.repository;

import modules.account.domain.event.Account;

public interface AccountRepository {

//    public boolean validateAccount(String accountid) {
//        return true;
//    }
    public boolean validateAccount(String accountId);
    public void save(Account account);

}
