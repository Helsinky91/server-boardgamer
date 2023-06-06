package boardgames.server.repository.games;

import boardgames.server.model.games.Category;
import boardgames.server.model.games.Game;
import boardgames.server.model.users.User;
import boardgames.server.repository.users.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameRepositoryTest {
    @Autowired
    GameRepository gameRepository;
    UserRepository userRepository;

    private Game game1;
    private Game game2;

    @BeforeEach
    public void setUp(){
//        User user1 = new User("John", "Doe", "john.doe@email.com", "password");
//        User user2 = new User("Jane", "Doe", "jane.doe@email.com", "password");
// userrepo.save(user1)

        //Game game1 = new Game(1, "pic of Catan", "Catan", "Devir", 10, 3, 4,
        //                "It is a game that combines strategy, cunning and the ability to negotiate and in which players try to colonize an island, Catan, rich in natural resources. Building towns, establishing trade routes, etc.",
        //                Category.FAMILY );
        game1 = new Game();
        game1.setId(1);
        game1.setPicture("https://upload.wikimedia.org/wikipedia/en/a/a3/Catan-2015-boxart.jpg");
        game1.setName("Catan");
        game1.setCategory(Category.FAMILY);
        game1.setBrand("Devir");
        game1.setMinAge(10);
        game1.setMinPlayers(3);
        game1.setMaxPlayers(4);
        game1.setDescription("It is a game that combines strategy, cunning and the ability to negotiate and in which players try to colonize an island, Catan, rich in natural resources. Building towns, establishing trade routes, etc.");
//        game1.setUser((Set<User>) user1);
//        game1.setUser((Set<User>) user2);

        gameRepository.save(game1);

        // Game game2 = new Game( 2, "pic of Sushi Party Go", "Sushy Party Go", "Devir", 8, 2, 8,
        //                "Sushi Go! It's a fun and fast card game where each player tries to eat the perfect menu of their favorite food. To do this, they have to combine the cards in the best possible way. The problem? That the cards circulate around the table at full speed and in each turn only one card can be played.",
        //                Category.FAMILY );
        game2 = new Game();
        //game2.setId(2);
        game2.setPicture("https://cf.geekdo-images.com/2f9uTicUSXkdPp2Yks6zFw__itemrep/img/Y_jPOWbp6_2qOzymSNIC6SZo4TE=/fit-in/246x300/filters:strip_icc()/pic5885689.jpg");
        game2.setName("Sushi Party Go");
        game2.setCategory(Category.FAMILY);
        game2.setBrand("Devir");
        game2.setMinAge(8);
        game2.setMinPlayers(2);
        game2.setMaxPlayers(8);
        game2.setDescription("Sushi Go! It's a fun and fast card game where each player tries to eat the perfect menu of their favorite food. To do this, they have to combine the cards in the best possible way. The problem? That the cards circulate around the table at full speed and in each turn only one card can be played.");
      //  game2.setUser((Set<User>) user1);
        gameRepository.save(game2);
    }

    @AfterEach
    public void tearDown() {gameRepository.deleteAll();}

    @Test
    public void findAll_games_gamesList(){
        List<Game> gameList = gameRepository.findAll();
        System.out.println(gameList);
        assertEquals(2, gameList.size());
    }

    @Test
    public void findById_validId_games(){
        System.out.println(game2.getId());
        Optional<Game> gameOptional = gameRepository.findById(game2.getId());
        System.out.println(gameOptional.get());
        assertTrue(gameOptional.isPresent());
    }
}