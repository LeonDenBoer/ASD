package modules.user.application;

import modules.user.domain.Account;
import modules.user.domain.User;
import modules.user.domain.repository.AccountRepository;
import modules.user.domain.repository.UserRepository;

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