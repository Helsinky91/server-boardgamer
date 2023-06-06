package boardgames.server.controller.impl.users;

import boardgames.server.controller.interfaces.users.IUserController;
import boardgames.server.controller.service.interfaces.users.IUserService;
import boardgames.server.model.users.User;
import boardgames.server.repository.users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    // *********************** POST *************************

    //! CREATE WHEN LOGGIN IN??
    //creo un post con login form para ambos tipos de user

    //en DB cambio manual user role a Admin
    //! NO CAL EL ADD-ADMIN

    // CREATE ONLY IF USER.TYPE === "ADMIN"
    @PostMapping("/add-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User newUser) {
        userService.createUser(newUser);
    }

    // *********************** PUT *************************

    @PutMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody @Valid User updatedUser, @PathVariable Integer id){
        userService.updateUser(updatedUser, id);
    }

    //! CREATE PACH TO EDIT ONLY ROLE OF USER IF ADMIN?
    //i.e. an admin wants to make another user admin



    // *********************** DELETE *************************

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }




}
