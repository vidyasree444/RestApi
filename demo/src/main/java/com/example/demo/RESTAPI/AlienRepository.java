package com.example.demo.RESTAPI;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlienRepository extends JpaRepository<Alien , Integer>{
    public List<Alien> findByName(String name);
    
}
