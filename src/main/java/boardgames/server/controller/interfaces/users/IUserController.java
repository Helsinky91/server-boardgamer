package boardgames.server.controller.interfaces.users;

import boardgames.server.controller.DTO.LoginDTO;
import boardgames.server.model.users.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface IUserController {
    Optional<User> getUserById( Integer id);
    void createUser(User newUser);
    void updateUser(User updatedUser, Integer id);
    void deleteUser(Integer id);

    User loginUser(LoginDTO loginDTO);
    void addGameToUser(Integer userId, Integer gameId);
    void addWishlistToUser(Integer userId, Integer gameId);
    void addFavouriteToUser(Integer userId, Integer gameId);
}
