package com.example.demo.RESTAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class Controller {

@Autowired
AlienRepository alienRepository;

    @GetMapping("/getvalues")
    public List<Alien> getvalues(){
     List<Alien> alien=alienRepository.findAll();
    return alien;
    } 

    @GetMapping("/findbyname")
    public List<Alien> name(@RequestParam String name){
        return alienRepository.findByName(name);
    }

     @PostMapping("/addalien")
    public Alien addAlien(@RequestBody Alien alien) {
        return alienRepository.save(alien);
    }

    @DeleteMapping("/{id}")
    public void deletealien(@PathVariable Integer id){
        alienRepository.deleteById(id);
    }
    
}
