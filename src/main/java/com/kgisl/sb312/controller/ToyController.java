package com.kgisl.sb312.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb312.entity.Toy;
import com.kgisl.sb312.service.ToyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/toys")
public class ToyController {

    @Autowired
    private ToyService toyService;

    // @Autowired
    // private ModelMapper modelMapper;

    @PostMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
        Toy actualToy = toyService.createToy(toy);
        HttpHeaders headers = new HttpHeaders();
        // headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(toy.getToyid()).toUri());
        return new ResponseEntity<>(actualToy, headers, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Toy>> all() {
        return new ResponseEntity<>(toyService.getToys(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Toy> getToyById(@PathVariable("id") long id) {
        Toy toy = toyService.findByToyId(id);
        if (toy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toy, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Toy> updateToy(@PathVariable("id") long id, @RequestBody Toy currentToy) {
        Toy toy = toyService.updateToy(id, currentToy);
        return new ResponseEntity<>(toy, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Toy> deleteToy(@PathVariable("id") Long id) {
        Toy user = toyService.findByToyId(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        toyService.deleteToyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
