package boardgames.server.controller.service.interfaces.users;

import boardgames.server.model.users.User;

public interface IUserService {

    void updateUser(User updatedUser, Integer id);
    void deleteUser(Integer id);
    void createUser(User newUser);
    User loginUser(String username, String password);
    void addGameToUser(Integer userId, Integer gameId);
    void addWishlistToUser(Integer userId, Integer gameId);
    void addFavouriteToUser(Integer userId, Integer gameId);
}
