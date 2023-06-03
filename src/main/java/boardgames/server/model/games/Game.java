package boardgames.server.model.games;

import boardgames.server.model.users.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //!how to
    private String picture;

    private String name;
    private String brand;
    private Integer minAge;
    private Integer minPlayers;
    private Integer maxPlayers;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    //    @ManyToOne //! OR ONE TO MANY?
    //    private User owner;

    //private Boolean favourites;


}
