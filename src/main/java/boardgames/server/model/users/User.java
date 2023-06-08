package boardgames.server.model.users;

import boardgames.server.model.games.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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

    @Size(min = 5, max = 12, message = "Username must be between 5 and 12 characters long")
    private String username;

    @Email(message = "Please provide a valid email")
    private String email;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 4, max = 20, message = "Password must be at least 4 characters long")
    @Pattern(regexp = "^(?=.*[A-Z]).+$", message = "Password must contain at least one uppercase letter")
    private String password;

    private String selfDescription;

    private LocalDate dateOfBirth;

    @Column(length = 1000)
    private String profilePicUrl = "https://cdn2.iconfinder.com/data/icons/essential-web-2/50/user-ciecle-round-account-placeholder-512.png";

    @Embedded
    private Address address;


    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_game",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "game_id") }
    )
    @JsonIgnoreProperties(value = { "user" }, allowSetters = true)
    private List<Game> games = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_favorites",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "favorites_id") }
    )
    @JsonIgnoreProperties(value = { "user" }, allowSetters = true)
    private List<Game> favorites = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_wishlist",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "wishlist_id") }
    )
    @JsonIgnoreProperties(value = { "user" }, allowSetters = true)
    private List<Game> wishlist = new ArrayList<>();

    public Integer getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(this.dateOfBirth, currentDate).getYears();
    }

    public void addToGamesList(Game game){
        games.add(game);
    }

    public void addToFavoritesList(Game game) {
        favorites.add(game);
    }

    public void addToWishlistList(Game game) {
        wishlist.add(game);
    }


}
