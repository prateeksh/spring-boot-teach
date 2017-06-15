package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Prateek on 6/15/2017.
 */
@RestController
public class TeachController {

    private TeachRepository repository;

    @Autowired
    public TeachController(TeachRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeachData> get(@PathVariable("id") Long id) {
        TeachData user = repository.findOne(id);
        if (null == user) {
            return new ResponseEntity<TeachData>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TeachData>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/addteach", method = RequestMethod.POST)
    public ResponseEntity<TeachData> update(@RequestBody TeachData user) {
        repository.save(user);
        return get(user.getId());
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public List<TeachData> all() {
        return repository.findAll();
    }

    @RequestMapping("/datacheck1")
    @ResponseBody
    String data() {
        return "check data teach";
    }
}
