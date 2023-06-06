package boardgames.server.controller.impl.games;

import boardgames.server.controller.service.interfaces.games.IGameService;
import boardgames.server.model.games.Category;
import boardgames.server.model.games.Game;
import boardgames.server.model.users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class GameControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    IGameService gameService;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }



    @Test
    void getAllGames_validRequest_allGames() throws Exception {
        Game game1 = new Game(1, "https://upload.wikimedia.org/wikipedia/en/a/a3/Catan-2015-boxart.jpg", "Catan", "Devir", 10, 3, 4, "It is a game that combines strategy, cunning and the ability to negotiate and in which players try to colonize an island, Catan, rich in natural resources. Building towns, establishing trade routes, etc.",
                Category.FAMILY, null);
        Game game2 = new Game( 2, "pic of Sushi Party Go", "Sushy Party Go", "Devir", 8, 2, 8,
                "Sushi Go! It's a fun and fast card game where each player tries to eat the perfect menu of their favorite food. To do this, they have to combine the cards in the best possible way. The problem? That the cards circulate around the table at full speed and in each turn only one card can be played.",
                Category.FAMILY, null );

        MvcResult mvcResult = mockMvc.perform(get("/api/games/")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Catan"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Sushi"));

    }

    @Test
    void getGameById_validId_game() throws Exception{
        Game game2 = new Game( 2, "pic of Sushi Party Go", "Sushy Party Go", "Devir", 8, 2, 8,
                "Sushi Go! It's a fun and fast card game where each player tries to eat the perfect menu of their favorite food. To do this, they have to combine the cards in the best possible way. The problem? That the cards circulate around the table at full speed and in each turn only one card can be played.",
                Category.FAMILY, null );
        MvcResult mvcResult = mockMvc.perform(get("/api/games/2")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Sushi"));

    }

    @Test
    void createGame_validGame_gameSaved() throws Exception{
        Game game3 = new Game( 3, "A testing game", "Testing", "Devir", 8, 2, 8,
                "This is a testing game",
                Category.TWO_PERSON, null );

        String body = objectMapper.writeValueAsString(game3);
        mockMvc.perform(put("/api/games/3").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/games"))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Testing"));
    }

}