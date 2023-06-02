package boardgames.server.model.users;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String city;

    @Override
    public String toString() {
        return "Address{" +
//                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
