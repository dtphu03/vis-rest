package vis.restsocial.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class Reply {
    @Id
    private Long id;
    private String content;
    private Long user_id;
    private Long answer_id;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private Long num_like;
}
