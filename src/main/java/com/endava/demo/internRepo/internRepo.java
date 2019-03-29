package com.endava.demo.internRepo;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface internRepo {
    List<Intern> getAll();
    public int save(Intern intern);
    public void delete(int id);
    public void update(int id,Intern intern_aux);
    Intern get(int id);
}
