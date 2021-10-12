package modules.user.adapter;

import modules.user.application.AccountApplicationService;

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