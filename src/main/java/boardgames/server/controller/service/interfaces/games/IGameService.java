package boardgames.server.controller.service.interfaces.games;

import boardgames.server.model.games.Game;

public interface IGameService {
    Game getGameById(Integer id);
    void createGame(Game newGame);
    void updateGame(Integer id, Game updatedGame);
    Game getRandomGame();
    void deleteGame(Integer id);
}
