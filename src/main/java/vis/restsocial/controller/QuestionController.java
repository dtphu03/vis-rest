package vis.restsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.model.Question;
import vis.restsocial.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> listAllQuestion() {
        List<Question> listQuestions = questionService.findAll();
        if (listQuestions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Question>>(listQuestions, HttpStatus.OK);

    }

    @RequestMapping(value = "/question/", method = RequestMethod.POST)
    public Question saveQuestion(Question question){
        return questionService.save(question);
    }

    @RequestMapping(value = "/question/", method = RequestMethod.PUT)
    public ResponseEntity<Question> updateQuestion (@PathVariable(value = "id") Long questionId, @RequestBody Question questionForm){
        Question question = questionService.getOne(questionId);
        if (question == null){
            return ResponseEntity.notFound().build();
        }
        question.setContent(questionForm.getContent());
        question.setUser_id(questionForm.getUser_id());
        question.setTitle_id(questionForm.getTitle_id());

        question.setNum_like(questionForm.getNum_like());

        Question updateQuestion = questionService.save(question);
        return ResponseEntity.ok(updateQuestion);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Question> deleteQuestion(@PathVariable(value = "id") Long id){
        Question question = questionService.getOne(id);
        if(question == null){
            return ResponseEntity.notFound().build();
        }
        questionService.delete(question);
        return ResponseEntity.ok().build();
    }
}
