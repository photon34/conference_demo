package com.pluralsightP1.conferencedemo.controllers;

import com.pluralsightP1.conferencedemo.models.Speaker;
import com.pluralsightP1.conferencedemo.respositories.SpeakerRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    private SpeakerRespository speakerRespository;

    public SpeakerController(SpeakerRespository speakerRespository) {
        this.speakerRespository = speakerRespository;
    }

    @GetMapping
    public List<Speaker> list() {
        return speakerRespository.findAll();
    }

    @GetMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRespository.findById(id).orElseThrow(() -> new RuntimeException("Speaker not found"));
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker){
        return speakerRespository.saveAndFlush(speaker);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        speakerRespository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRespository.findById(id).orElseThrow(() -> new RuntimeException("Speaker not found"));
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRespository.saveAndFlush(existingSpeaker);
    }
}
