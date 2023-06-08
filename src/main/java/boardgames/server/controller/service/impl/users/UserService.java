package boardgames.server.controller.service.impl.users;

import boardgames.server.controller.service.interfaces.users.IUserService;
import boardgames.server.model.games.Game;
import boardgames.server.model.users.Role;
import boardgames.server.model.users.User;
import boardgames.server.repository.games.GameRepository;
import boardgames.server.repository.users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GameRepository gameRepository;

    @Override
    public void updateUser(@RequestBody @Valid User updatedUser, @PathVariable Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");
        userRepository.deleteById(id);
    }

    @Override
    public void createUser(User newUser) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(newUser.getUsername(), newUser.getPassword());
        if(userOptional.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "this User already exists.");
        userRepository.save(newUser);
    }

    @Override
    public User loginUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");
        return userOptional.get();
    }

    @Override
    public void addGameToUser(Integer userId, Integer gameId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");

        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if(gameOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This Game doesn't exists");

        userOptional.get().addToGamesList(gameOptional.get());
        userRepository.save(userOptional.get());
    }

    @Override
    public void addWishlistToUser(Integer userId, Integer gameId) {
        Optional<User> userOptional = userRepository.findById(userId);
           if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");

        Optional<Game> gameOptional = gameRepository.findById(gameId);
            if(gameOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This Game doesn't exists");

        userOptional.get().addToWishlistList(gameOptional.get());
        userRepository.save(userOptional.get());
    }

    @Override
    public void addFavouriteToUser(Integer userId, Integer gameId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");

        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if(gameOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This Game doesn't exists");

        userOptional.get().addToFavoritesList(gameOptional.get());
        userRepository.save(userOptional.get());
    }



}
