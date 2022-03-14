package com.test.hib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

    /**
     * Incase you want to create another table add
     * a Employee class and attribute and also include the
     * the mapping
     */
    @Id
    private int  id;
    private String name ;
}
