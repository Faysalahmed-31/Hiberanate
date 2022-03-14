package com.test.hib.controller;

import java.util.Scanner;

public class Runnable {
    public static void main(String[] args) {
        /**
         *  create a runnable class to run findUser class for creating userInterface
         *
         */
        findUser_Hql objHql = new findUser_Hql();
        //objHql.findAllUsers();
        //objHql.getRecordByID();
        //objHql.getMaxSalary();

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        objHql.getAllUsers(input);
    }
}
