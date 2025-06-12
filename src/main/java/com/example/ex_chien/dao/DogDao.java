package com.example.ex_chien.dao;

import com.example.ex_chien.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DogDao {

    private static final SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Dog.class)
            .buildSessionFactory();

    public List<Dog> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Dog", Dog.class).list();
        }
    }

    public Dog findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Dog.class, id);
        }
    }

    public void save(Dog dog) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(dog);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
