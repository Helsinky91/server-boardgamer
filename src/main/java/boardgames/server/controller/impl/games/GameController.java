package boardgames.server.controller.impl.games;

import boardgames.server.controller.interfaces.games.IGameController;
import boardgames.server.model.games.Game;
import boardgames.server.repository.games.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController implements IGameController {

    @Autowired
    private GameRepository gameRepository;

    // *********************** GET *************************

    @GetMapping("")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Integer id) throws Exception {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) {
            return game.get();
        } else {
            throw new Exception("Game not found");
        }
    }

    // *********************** POST *************************
    @PostMapping("")
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
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