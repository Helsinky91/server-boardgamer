package boardgames.server.repository.games;

import boardgames.server.model.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findAll();

}
