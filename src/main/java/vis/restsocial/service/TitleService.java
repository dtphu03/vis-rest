package vis.restsocial.service;

import vis.restsocial.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleService extends JpaRepository<Title, Long>{
}
