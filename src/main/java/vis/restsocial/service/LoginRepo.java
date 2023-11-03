package vis.restsocial.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vis.restsocial.model.Login;
public interface LoginRepo extends JpaRepository<Login, Long> {
}
