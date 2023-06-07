package boardgames.server.controller.impl.users;

import boardgames.server.controller.DTO.LoginDTO;
import boardgames.server.controller.interfaces.users.IUserController;
import boardgames.server.controller.service.interfaces.users.IUserService;
import boardgames.server.model.users.User;
import boardgames.server.repository.games.GameRepository;
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
    @Autowired
    GameRepository gameRepository;

    // *********************** GET *************************

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable Integer id){
        return userRepository.findById(id);
    }


    // *********************** POST *************************

    //en DB cambio manual user role a Admin
    //! PUEDO HACER UN PATCH PARA CAMBIAR EL ROLE DEL USER SI ERES ADMIN, NECESITARÉ LISTA DE USERS....

       @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User newUser) {
        userService.createUser(newUser);
    }


    @PostMapping("/add-game/{userId}/{gameId}")
    public void addGameToUser(@PathVariable Integer userId, @PathVariable Integer gameId){
        userService.addGameToUser(userId, gameId);
    }
    @PostMapping("/add-wishlist/{userId}/{gameId}")
    public void addWishlistToUser(@PathVariable Integer userId, @PathVariable Integer gameId){
        userService.addWishlistToUser(userId, gameId);
    }
    @PostMapping("/add-favourite/{userId}/{gameId}")
    public void addFavouriteToUser(@PathVariable Integer userId, @PathVariable Integer gameId){
        userService.addFavouriteToUser(userId, gameId);
    }

    // *********************** PUT *************************

    @PutMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody @Valid User updatedUser, @PathVariable Integer id){
        userService.updateUser(updatedUser, id);
    }

    // *********************** PATCH *************************

    //! CREATE PACH TO EDIT ONLY ROLE OF USER IF ADMIN?
    //i.e. an admin wants to make another user admin

    //to check if the user already exists:
    @PatchMapping("/login")
    public User loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
    }


    // *********************** DELETE *************************

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }




}
