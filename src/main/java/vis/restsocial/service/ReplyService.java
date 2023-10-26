package vis.restsocial.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vis.restsocial.model.Reply;

public interface ReplyService extends JpaRepository<Reply,Long> {
}
