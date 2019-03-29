package com.endava.demo.internRepo;

import com.endava.demo.entity.Intern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository()
public class internRepoImpl implements internRepo {

    public static Session session;

    public static SessionFactory sessionFactory;


    public SessionFactory buildSessionFactory() {
        return sessionFactory = new Configuration()
                .addAnnotatedClass(Intern.class)
                .buildSessionFactory();
    }

    public Session buildSession() {
        session = buildSessionFactory().openSession();
        return session;
    }

    public Transaction buildTransaction() {
        Transaction tx = buildSession().beginTransaction();
        return tx;
    }

    public void closeTransaction() {
        buildTransaction().commit();
    }

    @Override
    public List<Intern> getAll() {
        List<Intern> internrepo = new ArrayList<Intern>();
        internrepo = buildSession().createQuery("Select i from Intern i", Intern.class).getResultList();
        buildSession().close();
        System.err.println("get" + internrepo);
        return internrepo;
    }

    @Override
    public int save(Intern intern) {
        Intern intern_aux = new Intern();
        intern_aux.setAge(intern.getAge());
        intern_aux.setName(intern.getName());
        intern_aux.setStream(intern.getStream());

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = (Integer) session.save(intern_aux);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Intern intern = (Intern) session.get(Intern.class, id);
        session.delete(intern);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(int id, Intern intern_aux) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Intern intern = (Intern) session.get(Intern.class, id);
            intern.setName(intern_aux.getName());
            intern.setAge(intern_aux.getAge());
            intern.setStream(intern_aux.getStream());
            session.getTransaction().commit();
            session.close();

    }

    @Override
    public Intern get(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Intern intern = (Intern) session.get(Intern.class, id);

        session.close();
        return intern;
    }
}