package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreatingUser {
    public static <user1> void main(String[] args) {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        User uone = new User();
        uone.setAge(20);
        uone.setCity("Saint Cloud");
        uone.setEmail("Faysalyare21@hotmail.com");
        uone.setFullname("Faisal Abdulle");
        uone.setPassword("root");
       //  uone.setId(1); remove the id and add into the transaction to generate auto-increment

        User uTwo = new User();
        uTwo.setAge(25);
        uTwo.setCity("Minneapolis");
        uTwo.setEmail("Fabdulle1998@gmailcom");
        uTwo.setFullname("makhtal Abdulle");
        uTwo.setPassword("root");
        //uTwo.setId(2); remove the id and add into the transaction to generate auto-increment

        User uThree = new User();
        uThree.setAge(40);
        uThree.setCity("iowa");
        uThree.setEmail("shueb@gmailcom");
        uThree.setFullname("shueb Abdulle");
        uThree.setPassword("root");
        //uTwo.setId(2); remove the id and add into the transaction to generate auto-increment


        User uFour = new User();
        uFour.setAge(23);
        uFour.setCity("marshale");
        uFour.setEmail("suud@gmailcom");
        uFour.setFullname("suud Abdulle");
        uFour.setPassword("root");
        //uTwo.setId(3); remove the id and add into the transaction to generate auto-increment

        User uFive = new User();
        uFive.setAge(30);
        uFive.setCity("st paul");
        uFive.setEmail("arumu@gmailcom");
        uFive.setFullname("shueb Abdulle");
        uFive.setPassword("root");
        //uTwo.setId(3); remove the id and add into the transaction to generate auto-increment






        Transaction t = s.beginTransaction();
        /**
         *  used the sessions to add IDs insert into table after
         *  transactions starts insert values into the table by passing an object to the save method
         */
        s.save(uone);
        s.save(uTwo);
        s.save(uThree);
        s.save(uFour);
        s.save(uFive);

        t.commit(); //
        System.out.println("Data is succesfully inserted in user table ");

        f.close();
        s.close();   // close both the factory and the session to avoid data likage


    }
}
