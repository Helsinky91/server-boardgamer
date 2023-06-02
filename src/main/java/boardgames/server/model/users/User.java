package boardgames.server.model.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
    private Type type;

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
