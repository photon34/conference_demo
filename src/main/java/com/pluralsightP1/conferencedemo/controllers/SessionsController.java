package com.pluralsightP1.conferencedemo.controllers;

import com.pluralsightP1.conferencedemo.models.Session;
import com.pluralsightP1.conferencedemo.respositories.SessionRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    private SessionRespository sessionRespository;

    public SessionsController(SessionRespository sessionRespository) {
        this.sessionRespository = sessionRespository;
    }

    @GetMapping
    public List<Session> list() {
        return sessionRespository.findAll();
    }

    @GetMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRespository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session){return sessionRespository.saveAndFlush(session);}

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        //NEED TO CHECK FOR CHILDREN RECORDS BEFORE DELETING
        sessionRespository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existitngSession = sessionRespository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
        BeanUtils.copyProperties(session, existitngSession, "session_id");
        return sessionRespository.saveAndFlush(existitngSession);
    }
}
