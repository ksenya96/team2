package dev.java.controller;

import dev.java.db.daos.InterviewDao;
import dev.java.db.model.Interview;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@RestController
public class InterviewController extends AbstractController<Interview> {
    @PostConstruct
    @Override
    public void initialize() {
        super.initialize();
        setSortedField("plan_date");
        setUrl("/interview/");
        setAbstractDao(new InterviewDao(getConnection()));
    }

    @Override
    @GetMapping("/interviews")
    public ResponseEntity getAllEntities(HttpServletRequest request) {
        return super.getAllEntities(request);
    }

    @Override
    @PostMapping("/interviews")
    public ResponseEntity createEntity(@RequestBody Interview interview, HttpServletRequest request) {
        return super.createEntity(interview, request);
    }

    @Override
    @GetMapping("/interview/{id:\\d+}")
    public ResponseEntity getEntity(@PathVariable long id, HttpServletRequest request) {
        return super.getEntity(id, request);
    }

    @Override
    @PutMapping("/interview/{id:\\d+}")
    public ResponseEntity updateEntity(@PathVariable long id, @RequestBody Interview interview,
                                       HttpServletRequest request) {
        return super.updateEntity(id, interview, request);
    }

    @Override
    @DeleteMapping("/interview/{id:\\d+}")
    public ResponseEntity deleteEntity(@PathVariable long id, HttpServletRequest request) {
        return super.deleteEntity(id, request);
    }
}
