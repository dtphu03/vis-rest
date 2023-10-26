package vis.restsocial.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vis.restsocial.model.Answer;

public interface AnswerService extends JpaRepository<Answer,Long> {
}
