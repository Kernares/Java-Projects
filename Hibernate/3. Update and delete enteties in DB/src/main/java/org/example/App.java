package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person4 = new Person("Primarh", 2022);
            session.save(person4);
            System.out.println(person4.getId());
//            Person person = session.get(Person.class, 2);
//            person.setAge(8);
//            session.delete(2);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
