package boardgames.server.controller.service.impl.games;

import boardgames.server.controller.service.interfaces.games.IGameService;
import boardgames.server.model.games.Game;
import boardgames.server.repository.games.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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
    public void createGame(Game newGame) {
        Optional<Game> gameOptional = gameRepository.findById(newGame.getId());
        if(gameOptional.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "this Game already exist");
        gameRepository.save(newGame);
    }


}
