package vis.restsocial.service;

import vis.restsocial.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicService  extends JpaRepository<Topic, Long> {
}
