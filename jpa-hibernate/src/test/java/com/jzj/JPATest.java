package com.jzj;

import com.jzj.pojo.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @Author Jzj
 * @Date 2022/3/15 21:36
 * @Version 1.0
 * @Message:
 */
public class JPATest {
    EntityManagerFactory factory;

    @Before
    public void before(){
        factory= Persistence.createEntityManagerFactory("hibernateJPA");
    }

    @Test
    public void testC(){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = new Customer();
        customer.setCustName("张三");
        entityManager.persist(customer);
        tx.commit();
    }
    @Test
    public void testC02(){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class, 2L);
        customer.setCustName("存储");
        tx.commit();
    }
}
