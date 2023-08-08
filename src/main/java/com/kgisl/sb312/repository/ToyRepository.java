package com.kgisl.sb312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.sb312.entity.Toy;

@Repository
public interface ToyRepository extends JpaRepository<Toy,Long>{
    
}
