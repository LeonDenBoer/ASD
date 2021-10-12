package modules.user.domain.repository;


import modules.user.domain.User;

public interface UserRepository {

    public void saveUser(User user);
}