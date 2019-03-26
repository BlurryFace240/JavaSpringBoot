package com.endava.demo.internRepo;

import com.endava.demo.entity.Intern;
import com.endava.demo.entity.InternStreams;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class internRepoImpl implements internRepo{

    Session session;
    SessionFactory sessionFactory;

    public internRepoImpl(Session session)
    {
        this.session=session;
    }



//    @Override
//    public List<Intern> getAll() {x
//        sessionFactory.openSession().createQuery("Select i From Intern i",Intern.class);
//    }

    @Override
    public void save(Intern intern) {
        Transaction tx= session.beginTransaction();
        session.save(new Intern("BlurryFace",18, InternStreams.NET));
        tx.commit();
    }
}
