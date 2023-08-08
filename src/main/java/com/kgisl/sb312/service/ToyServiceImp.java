package com.kgisl.sb312.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.sb312.entity.Toy;
import com.kgisl.sb312.repository.ToyRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ToyServiceImp implements ToyService {

    @Autowired
    private ToyRepository toyRepository;

    @Override
    public List<Toy> getToys() {
        return toyRepository.findAll();

    }

    @Override
    public Toy findByToyId(Long id) {
        return toyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public Toy createToy(Toy toy) {
        return toyRepository.save(toy);

    }

    @Override
    public Toy updateToy(Long id, Toy toy) {
        Toy t = toyRepository.findById(id).orElse(new Toy());

        t.setName(toy.getName());
        t.setPrice(toy.getPrice());
        return toyRepository.save(toy);
    }

    @Override
    public void deleteToyById(Long id) {
        toyRepository.deleteById(id);

    }

}
