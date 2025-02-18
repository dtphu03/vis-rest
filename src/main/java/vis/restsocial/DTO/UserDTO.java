package vis.restsocial.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private Date date;
    private Long phone;
    private String email;
}
