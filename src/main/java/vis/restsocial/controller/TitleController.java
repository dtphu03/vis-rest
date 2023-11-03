package vis.restsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.model.Title;
import vis.restsocial.service.TitleRepo;


import java.util.List;

@RestController
@RequestMapping("/api")
public class TitleController {
    @Autowired
    TitleRepo titleRepo;

    @RequestMapping(value = "/title", method = RequestMethod.GET)
    public ResponseEntity<List<Title>> listAllTitle() {
        List<Title> listTitles = titleRepo.findAll();
        if (listTitles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Title>>(listTitles, HttpStatus.OK);

    }

    @RequestMapping(value = "/title/", method = RequestMethod.POST)
    public Title saveTitle(Title title){
        return titleRepo.save(title);
    }

    @RequestMapping(value = "/title/", method = RequestMethod.PUT)
    public ResponseEntity<Title> updateTitle (@PathVariable(value = "id") Long titleId, @RequestBody Title titleForm){
        Title title = titleRepo.getOne(titleId);
        if (title == null){
            return ResponseEntity.notFound().build();
        }
        title.setName(titleForm.getName());
        title.setTopic_id(titleForm.getTopic_id());

        Title updateTitle = titleRepo.save(title);
        return ResponseEntity.ok(updateTitle);
    }

    @RequestMapping(value = "/title/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Title> deleteTitle(@PathVariable(value = "id") Long id){
        Title title = titleRepo.getOne(id);
        if(title == null){
            return ResponseEntity.notFound().build();
        }
        titleRepo.delete(title);
        return ResponseEntity.ok().build();
    }
}
