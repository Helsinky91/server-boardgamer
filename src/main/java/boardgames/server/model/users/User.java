package boardgames.server.model.users;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


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
    private Role role;

    //@Min
    //@MAX
    private String username;

    //@MIN
    //@MAX
    private String password;

    //! either dateOfBirth or age
    private LocalDate dateOfBirth;
    private Integer age;

    @Embedded
    private Address address;
}
