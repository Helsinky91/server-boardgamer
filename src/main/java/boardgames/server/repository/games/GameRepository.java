package boardgames.server.repository.games;

import boardgames.server.model.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findAll();
    Optional<Game> findById(Integer integer);
}
