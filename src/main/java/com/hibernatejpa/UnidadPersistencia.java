package com.hibernatejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UnidadPersistencia {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private static UnidadPersistencia ourInstance = new UnidadPersistencia();

    public static UnidadPersistencia getInstance() {
        return ourInstance;
    }

    private UnidadPersistencia() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
