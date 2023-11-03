package vis.restsocial.repo;

import vis.restsocial.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepo extends JpaRepository<Title, Long>{
}
