package boardgames.server.controller.service.impl.users;

import boardgames.server.controller.service.interfaces.users.IUserService;
import boardgames.server.model.users.User;
import boardgames.server.repository.users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void updateUser(@RequestBody @Valid User updatedUser, @PathVariable Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Holder doesn't exists");
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }


}
