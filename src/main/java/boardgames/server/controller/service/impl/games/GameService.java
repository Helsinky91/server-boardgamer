package boardgames.server.controller.service.impl.games;

import boardgames.server.controller.service.interfaces.games.IGameService;
import boardgames.server.repository.games.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService {

    @Autowired
    GameRepository gameRepository;
}
