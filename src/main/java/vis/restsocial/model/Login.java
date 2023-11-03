package vis.restsocial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Login {
    @Id
    private String account;
    private Long password;
    private Long user_id;
}
