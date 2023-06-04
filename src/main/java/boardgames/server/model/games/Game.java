package boardgames.server.model.games;

import boardgames.server.model.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //!how to insert pics from DB
    private String picture;

    private String name;
    private String brand;
    private Integer minAge;
    private Integer minPlayers;
    private Integer maxPlayers;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    //!like this?
    @ManyToMany(mappedBy = "games")
    private Set<User> user = new HashSet<>();

    //private Boolean favourites;


}
