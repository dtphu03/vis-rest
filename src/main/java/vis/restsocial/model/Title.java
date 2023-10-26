package vis.restsocial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Title {
    @Id
    private Long id;

    private String name;

    private Long topic_id;
}
