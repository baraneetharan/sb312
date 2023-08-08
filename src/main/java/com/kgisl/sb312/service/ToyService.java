package com.kgisl.sb312.service;

import java.util.List;

import com.kgisl.sb312.entity.Toy;

public interface ToyService {
    public List<Toy> getToys();
    public Toy findByToyId(Long id);
    public Toy createToy(Toy toy);
    public Toy updateToy(Long id,Toy toy);
    public void deleteToyById(Long id);
}
