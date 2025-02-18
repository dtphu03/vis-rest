package vis.restsocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.model.Answer;
import vis.restsocial.repo.AnswerRepo;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswerController {
    AnswerRepo answerRepo;

    @GetMapping(value = "/answer")
    public ResponseEntity<List<Answer>> listAllAnswer() {
        List<Answer> listAnswers = answerRepo.findAll();
        if (listAnswers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Answer>>(listAnswers, HttpStatus.OK);

    }

    @RequestMapping(value = "/answer/", method = RequestMethod.POST)
    public Answer saveAnswer(Answer answer){
        return answerRepo.save(answer);
    }

    @RequestMapping(value = "/answer/", method = RequestMethod.PUT)
    public ResponseEntity<Answer> updateAnswer (@PathVariable(value = "id") Long answerId, @RequestBody Answer answerForm){
        Answer answer = answerRepo.getOne(answerId);
        if (answer == null){
            return ResponseEntity.notFound().build();
        }
        answer.setContent(answerForm.getContent());
        answer.setUser_id(answerForm.getUser_id());


        answer.setNum_like(answerForm.getNum_like());

        Answer updateAnswer = answerRepo.save(answer);
        return ResponseEntity.ok(updateAnswer);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Answer> deleteAnswer(@PathVariable(value = "id") Long id){
        Answer answer = answerRepo.getOne(id);
        if(answer == null){
            return ResponseEntity.notFound().build();
        }
        answerRepo.delete(answer);
        return ResponseEntity.ok().build();
    }
}
