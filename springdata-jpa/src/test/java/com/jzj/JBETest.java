package com.jzj;

import com.jzj.config.SpringDataJpaConfig;
import com.jzj.pojo.Customer;
import com.jzj.repositories.CustomerQBERepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author Jzj
 * @Date 2022/3/15 23:15
 * @Version 1.0
 * @Message:
 */
@ContextConfiguration(classes = SpringDataJpaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JBETest {
    @Autowired
    CustomerQBERepository customerQBERepository;

    @Test
    public void testR(){
        Customer customer = new Customer();
        customer.setCustName("梁朝伟");
        customer.setCustAddress("北京");
        //通过Example构建条件
        Example<Customer> example = Example.of(customer);
        List<Customer> list = (List<Customer>) customerQBERepository.findAll(example);
        for (Customer customer1 : list) {
            System.out.println(customer1);
        }
    }



}
