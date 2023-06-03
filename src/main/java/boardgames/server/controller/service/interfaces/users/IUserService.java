package boardgames.server.controller.service.interfaces.users;

import boardgames.server.model.users.User;

import java.nio.file.AccessDeniedException;

public interface IUserService {

    void updateUser(User updatedUser, Integer id);
    void deleteUser(Integer id);

    void createUser(User newUser);
}
