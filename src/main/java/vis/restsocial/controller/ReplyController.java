package vis.restsocial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.model.Reply;
import vis.restsocial.service.ReplyRepo;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReplyController {
    @Autowired
    ReplyRepo replyRepo;

    @RequestMapping(value = "/reply", method = RequestMethod.GET)
    public ResponseEntity<List<Reply>> listAllReply() {
        List<Reply> listReplys = replyRepo.findAll();
        if (listReplys.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Reply>>(listReplys, HttpStatus.OK);

    }

    @RequestMapping(value = "/reply/", method = RequestMethod.POST)
    public Reply saveReply(Reply reply){
        return replyRepo.save(reply);
    }

    @RequestMapping(value = "/reply/", method = RequestMethod.PUT)
    public ResponseEntity<Reply> updateReply (@PathVariable(value = "id") Long replyId, @RequestBody Reply replyForm){
        Reply reply = replyRepo.getOne(replyId);
        if (reply == null){
            return ResponseEntity.notFound().build();
        }
        reply.setContent(replyForm.getContent());
        reply.setUser_id(replyForm.getUser_id());
        reply.setAnswer_id(replyForm.getAnswer_id());

        reply.setNum_like(replyForm.getNum_like());

        Reply updateReply = replyRepo.save(reply);
        return ResponseEntity.ok(updateReply);
    }

    @RequestMapping(value = "/reply/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Reply> deleteReply(@PathVariable(value = "id") Long id){
        Reply reply = replyRepo.getOne(id);
        if(reply == null){
            return ResponseEntity.notFound().build();
        }
        replyRepo.delete(reply);
        return ResponseEntity.ok().build();
    }
}
