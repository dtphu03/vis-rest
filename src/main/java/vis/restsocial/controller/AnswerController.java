package vis.restsocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.model.Answer;
import vis.restsocial.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "/answer", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> listAllAnswer() {
        List<Answer> listAnswers = answerService.findAll();
        if (listAnswers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Answer>>(listAnswers, HttpStatus.OK);

    }

    @RequestMapping(value = "/answer/", method = RequestMethod.POST)
    public Answer saveAnswer(Answer answer){
        return answerService.save(answer);
    }

    @RequestMapping(value = "/answer/", method = RequestMethod.PUT)
    public ResponseEntity<Answer> updateAnswer (@PathVariable(value = "id") Long answerId, @RequestBody Answer answerForm){
        Answer answer = answerService.getOne(answerId);
        if (answer == null){
            return ResponseEntity.notFound().build();
        }
        answer.setContent(answerForm.getContent());
        answer.setUser_id(answerForm.getUser_id());


        answer.setNum_like(answerForm.getNum_like());

        Answer updateAnswer = answerService.save(answer);
        return ResponseEntity.ok(updateAnswer);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Answer> deleteAnswer(@PathVariable(value = "id") Long id){
        Answer answer = answerService.getOne(id);
        if(answer == null){
            return ResponseEntity.notFound().build();
        }
        answerService.delete(answer);
        return ResponseEntity.ok().build();
    }
}
