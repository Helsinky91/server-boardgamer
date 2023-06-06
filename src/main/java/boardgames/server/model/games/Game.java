package boardgames.server.model.games;

import boardgames.server.model.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //!how to . uso scr en html y le paso {{picture}}
    @Column(length = 1000)
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
    @ManyToMany(mappedBy = "games", fetch = FetchType.EAGER)
    private List<User> user = new ArrayList<>();

    //private Boolean favourites;


}
