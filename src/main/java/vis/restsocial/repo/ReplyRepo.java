package vis.restsocial.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vis.restsocial.model.Reply;

public interface ReplyRepo extends JpaRepository<Reply,Long> {
}
