package com.castellano.client;

import com.castellano.entity.Message;
import com.castellano.util.HibernateUtil;
import org.hibernate.Session;

public class HelloWorldClient {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        Message message = new Message( "Hello World with Hibernate and JPA Annotations" );
        Message message = (Message) session.get(Message.class, 2L);
        session.save(message);

        session.getTransaction().commit();
        session.close();

        message.setText("Hi");

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();

        session2.merge(message);

        session2.getTransaction().commit();
        session2.close();
    }
}
