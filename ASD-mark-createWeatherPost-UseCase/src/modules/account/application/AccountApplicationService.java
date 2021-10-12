package modules.account.application;

import modules.account.domain.event.Account;
import modules.account.domain.event.User;
import modules.account.domain.repository.AccountRepository;
import modules.account.domain.repository.UserRepository;

import java.util.Date;

public class AccountApplicationService {

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountApplicationService(AccountRepository accountRepository, UserRepository userRepository){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }




    public void createAccount(String username, String firstname, String lastname, String prefix, String email, String password) {
       boolean doesNotExistAlready = accountRepository.validateAccount(username);
       if(doesNotExistAlready){
           Account account = new Account(username,firstname, lastname, prefix, email, password);
           User user = new User(username);
           accountRepository.save(account);
           userRepository.saveUser(user);

       }
    }
}
