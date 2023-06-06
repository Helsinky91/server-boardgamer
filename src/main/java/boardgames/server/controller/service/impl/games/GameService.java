package boardgames.server.controller.service.impl.games;

import boardgames.server.controller.service.interfaces.games.IGameService;
import boardgames.server.model.games.Game;
import boardgames.server.repository.games.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameService implements IGameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game getGameById(Integer id)  {
        Optional<Game> gameOptional = gameRepository.findById(id);
        if (gameOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        return gameOptional.get();
    }

    @Override
    public Game getRandomGame() {
        List<Game> allGames = gameRepository.findAll();
        Integer randomId = null;

        do {
            randomId = allGames.get(new Random().nextInt(allGames.size())).getId();
        } while (gameRepository.findById(randomId).isEmpty());

        return gameRepository.getById(randomId);
    }

    @Override
    public void createGame(Game newGame) {
        Optional<Game> gameOptional = gameRepository.findById(newGame.getId());
        if(gameOptional.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "this Game already exist");
        gameRepository.save(newGame);
    }

    @Override
    public void updateGame(Integer id, Game updatedGame) {
        Optional<Game> existingGame = gameRepository.findById(id);
        if (existingGame.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        updatedGame.setId(id);
        gameRepository.save(updatedGame);
    }

    @Override
    public void deleteGame(Integer id) {
        Optional<Game> gameOptional = gameRepository.findById(id);
        if (gameOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        gameRepository.deleteById(id);
    }

}
