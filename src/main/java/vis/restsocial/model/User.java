package vis.restsocial.model;

import jakarta.persistence.*;
import lombok.Getter;


import java.util.Date;


@Getter
@Entity
public class User  {
    @Id
    private Long id;

    private String name;

    private Date date;

    private Long phone;

    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
