package boardgames.server.controller.interfaces.games;

import boardgames.server.model.games.Game;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface IGameController {
    List<Game> getAllGames();
    Game getGameById(Integer id);
    void createGame(Game newGame);
    Game getRandomGame();
    void updateGame(Integer id, Game updatedGame);
    void deleteGame(Integer id);
}
