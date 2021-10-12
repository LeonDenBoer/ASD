package modules.account.domain.repository;

import modules.account.domain.event.User;

public interface UserRepository {

    public void saveUser(User user);
}
