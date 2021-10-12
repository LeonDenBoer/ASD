package modules.account.adapter;

import modules.account.application.AccountApplicationService;
import modules.account.domain.repository.AccountRepository;

import java.util.Date;

public class AccountRESTController {

    private AccountApplicationService accountApplicationService;

    public AccountRESTController(AccountApplicationService accountApplicationService){
        this.accountApplicationService = accountApplicationService;
    }

//    @POST
    public void createAccount(String username, String firstname, String lastname, String prefix, String email, String password){
        accountApplicationService.createAccount( username, firstname,  lastname,  prefix,  email,  password);

    }





}
