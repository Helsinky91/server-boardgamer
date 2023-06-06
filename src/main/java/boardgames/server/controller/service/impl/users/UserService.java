package boardgames.server.controller.service.impl.users;

import boardgames.server.controller.service.interfaces.users.IUserService;
import boardgames.server.model.users.Role;
import boardgames.server.model.users.User;
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

    @Override
    public void updateUser(@RequestBody @Valid User updatedUser, @PathVariable Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> accHolderOptional = userRepository.findById(id);
        if(accHolderOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This User doesn't exists");
        userRepository.deleteById(id);
    }

    @Override
    public void createUser(User newUser) {
        Optional<User> userOptional = userRepository.findById(newUser.getId());
        if(userOptional.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "this User already exists.");
//        if(newUser.getRole() == Role.ADMIN) {
            userRepository.save(newUser);

    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.empty();
    }


}
