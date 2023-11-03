package vis.restsocial.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vis.restsocial.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}
