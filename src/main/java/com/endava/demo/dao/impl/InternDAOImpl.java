package com.endava.demo.dao.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import org.springframework.stereotype.Repository;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.endava.demo.entity.InternStreams.ANALYST;
import static com.endava.demo.entity.InternStreams.JAVA;

@Repository
public class InternDAOImpl implements InternDAO {

    private static List<Intern> internList = new ArrayList<>();

    static {
        internList.add(new Intern(1,"Mihaela", 21, JAVA));
        internList.add(new Intern( 2,"Eugen", 18, JAVA));
        internList.add(new Intern( 3,"Xenia", 19, JAVA));
        internList.add(new Intern( 4,"Denisa", 21, ANALYST));
    }

    @Override
    public List<Intern> findAll() {
        return internList;
    }

    @Override
    public void save(Intern intern) {
        internList.add(intern);

    }

    @Override
    public int getMaxID() {
        return internList
                .stream()
                .max(Comparator.comparingInt(Intern::getId))
                .get()
                .getId();
    }

    @Override
    public void delete(int id) {
        for (Intern i : new ArrayList<>(internList))
        {
            if (i.getId() == id)
                internList.remove(i);
        }
    }

    @Override
    public int getId(Intern intern) {
        return internList.indexOf(intern);
    }

    @Override
    public Intern getByID(int id) {
        for (Intern i:internList) {
            if (i.getId()==id)
                return i;
        }
        return null;
    }

    @Override
    public void update(int id,Intern intern) {
        internList.set(getId(getByID(id)),intern);
    }
}

