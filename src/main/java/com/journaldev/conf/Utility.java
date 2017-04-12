package com.journaldev.conf;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {
    private static EntityManagerFactory entityManagerFactory;

    //@BeforeClass
    public static EntityManagerFactory setUpEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory( "MyPU" );
        return entityManagerFactory;
    }

    //@AfterClass
    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}