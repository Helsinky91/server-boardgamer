package boardgames.server.controller.impl.games;

import boardgames.server.controller.interfaces.games.IGameController;
import boardgames.server.controller.service.impl.games.GameService;
import boardgames.server.model.games.Game;
import boardgames.server.repository.games.GameRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController implements IGameController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameService gameService;

    // *********************** GET *************************

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable Integer id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/random-game")
    @ResponseStatus(HttpStatus.OK)
    public Game getRandomGame(){
        return gameService.getRandomGame();
    }

    // *********************** POST *************************
    @PostMapping("/add-game")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGame(@RequestBody @Valid Game newGame) {
        gameService.createGame(newGame);
    }

    // *********************** PUT *************************
    @PutMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable Integer id, @RequestBody Game updatedGame) {
        gameService.updateGame(id, updatedGame);
    }

    // *********************** DELETE *************************
    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
    }
}