package boardgames.server.model.users;

import boardgames.server.model.games.Game;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //admin or user
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER; //default value is Role.USER

    @Size(min = 8, max = 12, message = "Username must be between 8 and 12 characters long")
    private String username;

    @Email(message = "Please provide a valid email")
    private String email;

    @Min(value = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Z]).+$", message = "Password must contain at least one uppercase letter")
    private String password;

    private String selfDescription;

    private LocalDate dateOfBirth;

    //!how to . uso scr en html y le paso {{profile.pic}}
    @Column(length = 1000)
    private String profilePic;

    @Embedded
    private Address address;

    //private String[] favourites;
    //private String[] wishlist;

        //! es mejor usar String myGames o Set<Game> ??
    //private String[] myGames;
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_game",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "game_id") }
    )
    private List<Game> games = new ArrayList<>();

    public Integer getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(this.dateOfBirth, currentDate).getYears();
    }



}
