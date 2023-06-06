package boardgames.server.model.games;

import boardgames.server.model.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

        @Column(length = 1000)
    private String picture = "https://img.freepik.com/vector-premium/esbozo-dos-dados-juego-dados-dibujo-vectorial_231873-30.jpg";

    private String name;
    private String brand;
    private Integer minAge;
    private Integer minPlayers;
    private Integer maxPlayers;

    //! COLLECTIONS????
    //private String[] collection;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToMany(mappedBy = "games", fetch = FetchType.EAGER)
    private List<User> user = new ArrayList<>();

    //private Boolean favourites;


}
