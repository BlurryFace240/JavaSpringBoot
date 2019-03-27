package com.endava.demo.internRepo;

import com.endava.demo.entity.Intern;
import com.endava.demo.entity.InternStreams;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class internRepoImpl implements internRepo{

    Session session;
    SessionFactory sessionFactory;

    public internRepoImpl(Session session)
    {
        this.session=session;
    }



    @Override
    public List<Intern> getAll() {
        List<Intern> internrepo=new ArrayList<Intern>();
        sessionFactory.openSession().createQuery("Select * From Intern ",Intern.class);
        return internrepo;
    }

    @Override
    public void save(Intern intern) {
        Transaction tx= session.beginTransaction();
        session.save(intern);
        tx.commit();
    }
}
