package com.endava.demo.service;

import com.endava.demo.entity.Intern;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InternService {
    public List<Intern> getAllInterns();

    public void add(Intern intern);

    public void remove(int id);

    public Intern getByID(int id);

    public void update(int id, Intern intern);
}
