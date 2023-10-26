package vis.restsocial.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vis.restsocial.model.User;

@Repository
public interface UserService  extends JpaRepository<User, Long > {
}
