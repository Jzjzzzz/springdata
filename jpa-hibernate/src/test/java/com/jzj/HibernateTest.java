package com.jzj;

import com.jzj.pojo.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Author Jzj
 * @Date 2022/3/15 21:09
 * @Version 1.0
 * @Message:
 */
public class HibernateTest {

    private SessionFactory sf;

    @Before
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();

        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂

        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    @Test
    public void testC(){
        try(Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustName("张学友");
            session.save(customer);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testR(){
        try(Session session = sf.openSession()) {
            Customer customer = session.find(Customer.class, 2L);
            System.out.println(customer);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testR_HQL(){
        try(Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            String hql = " from Customer where custId=:id";
            List<Customer> resultList = session.createQuery(hql, Customer.class).setParameter("id", 2L).getResultList();
            System.out.println(resultList);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
