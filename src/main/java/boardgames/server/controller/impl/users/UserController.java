package boardgames.server.controller.impl.users;

import boardgames.server.controller.interfaces.users.IUserController;
import boardgames.server.controller.service.interfaces.users.IUserService;
import boardgames.server.model.users.User;
import boardgames.server.repository.users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController implements IUserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    IUserService userService;

    // *********************** GET *************************

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody @Valid User updatedUser, @PathVariable Integer id){
        userService.updateUser(updatedUser, id);
    }




}
