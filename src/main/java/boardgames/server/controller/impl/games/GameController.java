package boardgames.server.controller.impl.games;

import boardgames.server.controller.interfaces.games.IGameController;
import boardgames.server.controller.service.impl.games.GameService;
import boardgames.server.model.games.Game;
import boardgames.server.repository.games.GameRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController implements IGameController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameService gameService;

    // *********************** GET *************************

    @GetMapping("")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Integer id) {
        return gameService.getGameById(id);
    }

    // *********************** POST *************************
    @PostMapping("/add-game")
    public void createGame(@RequestBody @Valid Game newGame) {
        gameService.createGame(newGame);
    }

    // *********************** PUT *************************
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Integer id, @RequestBody Game game) throws Exception {
        Optional<Game> existingGame = gameRepository.findById(id);
        if (existingGame.isPresent()) {
            Game updatedGame = existingGame.get();
            updatedGame.setName(game.getName());
            updatedGame.setDescription(game.getDescription());
            return gameRepository.save(updatedGame);
        } else {
            throw new Exception("Game not found");
        }
    }
    // *********************** DELETE *************************
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Integer id) {
        gameRepository.deleteById(id);
    }
}