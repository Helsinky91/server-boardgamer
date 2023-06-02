package boardgames.server.controller.service.impl.games;

import boardgames.server.controller.service.interfaces.games.IGameService;
import boardgames.server.repository.games.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GameService implements IGameService {

    @Autowired
    GameRepository gameRepository;
}
