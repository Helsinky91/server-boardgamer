package boardgames.server.controller.interfaces.games;

import boardgames.server.model.games.Game;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IGameController {
    List<Game> getAllGames();
    Game getGameById(Integer id);
    Game createGame(Game game);

}
