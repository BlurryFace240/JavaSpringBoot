package com.endava.demo.service.impl;

import com.endava.demo.entity.Intern;
import com.endava.demo.internRepo.internRepo;
import com.endava.demo.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InternServiceImpl implements InternService {

    @Autowired
    private internRepo internRepo;

    @Override
    public List<Intern> getAllInterns() {
        return internRepo.getAll();
    }

    @Override
    public void add(Intern intern) {
        internRepo.save(intern);
    }
     @Override
    public void remove(int id)
     {
        internRepo.delete(id);
     }

    @Override
    public Intern getByID(int id) {
        return internRepo.get(id);
    }

    @Override
    public void update(int id, Intern intern) {
        internRepo.update(id,intern);
    }
}
