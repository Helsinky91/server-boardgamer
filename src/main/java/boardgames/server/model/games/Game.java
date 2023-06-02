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

//    @ManyToOne //! OR ONE TO MANY?
//    private User owner;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    
}