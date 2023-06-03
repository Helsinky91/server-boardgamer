package boardgames.server.controller.interfaces.users;

import boardgames.server.model.users.User;

import java.util.Optional;

public interface IUserController {
    Optional<User> getUserById( Integer id);
    void createUser(User newUser);
    void updateUser(User updatedUser, Integer id);
    void deleteUser(Integer id);
}
