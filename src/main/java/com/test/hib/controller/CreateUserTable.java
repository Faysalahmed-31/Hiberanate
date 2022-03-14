package com.test.hib.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CreateUserTable {
    public static void main(String[] args) {
        /**
         * create the main method
         * create connection configuration to activate the hibernate
         * Configuration cfg = new Configuration();
         */


      /**  @ method One
       *
       * Configuration cfg = new Configuration(); // activated the connection
      Configuration c = cfg.configure();  // looking for hibernate.cfg.xml for db information
        SessionFactory f = c.buildSessionFactory(); // return Database connection
        Session s = f.openSession(); // create a session for available connection */

        //@ method Two
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();




        //Transaction t = s.beginTransaction();  // you dont need to create a table with transaction



    }



    }

