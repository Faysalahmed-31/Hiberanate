package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;


public class findUser_Hql {
    /**Example for HQL to get all records from USER TABLE
     * CREATE A method
     * setup the factory configuration connection
     *
     */
    public void findAllUsers(){
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        /** CREATE QUERY INTERFACE by [create query method]
         *
         */
        //String hql = "From User";   YOU CAN USE the second options to retrieve data from DB
        String hql = "SELECT U From User";
        Query q = s.createQuery(hql); // is depreciated
        q.getResultList(); // to get many result user getResultList method instead of list method
        List<User> uList = q.getResultList(); // list is a generic type

        for (User u : uList){
            System.out.println("user id: " + u.getId() + "user name: " + u.getFullname()
             + "user City:  " + u.getCity() + " user Email: " + u.getEmail() + " user Salary: " +u.getSalary());
        }

        f.close();
        s.close();

    }
    //Unable to resolve path [u.id], unexpected token [u] [Select u FROM com.test.hib.model.User where u.id < 3 ORDER BY u.id DESC ]
    public void getRecordByID(){
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        String hql = "Select u FROM User u where u.age < 20 ORDER BY u.id DESC ";

        Query q = s.createQuery(hql);
        List<User> uList = q.getResultList();
        for (User u: uList){
            System.out.println("user id: "+ u.getId() + "user name: " + u.getFullname() + "user email: " + u.getEmail()
            + "user city: " + u.getCity() + "user salary: " + u.getSalary());
        }

        f.close();
        s.close();
    }

    /**
     * create a new method of getMaxSalary to get the max salary
     * from the table since our getting dingle result from the table
     * use getSingleResult method to get the query and store the salary value  in double
     * cast the datatype and print out
     */
    public  void  getMaxSalary(){
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        //String hqlQuery = "Select max(u.salary) FROM User u ";
//        Query q =   s.createQuery(hqlQuery);
//        double data = (Double) q.getSingleResult();

        String hqlQuery = "Select count(u) FROM User u ";
         Query q = s.createQuery(hqlQuery);
         double data = (Double) q.getSingleResult();


        System.out.println("Max salary: " + data);

    }
    public void getAllUsers(int getUsers){
        /**
         * Demo for parametrized query is also called prepared statement
         *
         */
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        String hql = "select u from User u where u.id = :userid";
        TypedQuery q = s.createQuery(hql);
        q.setParameter("userid", getUsers);
        List <User> uList = q.getResultList();

        for (User u : uList){
            System.out.println("user id: "+ u.getId() + "user fullName: "+u.getFullname() + "Email "+ u.getEmail()
            + " City : "+ u.getCity());
        }
    }
}
