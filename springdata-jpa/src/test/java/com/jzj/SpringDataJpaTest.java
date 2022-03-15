package com.jzj;

import com.jzj.config.SpringDataJpaConfig;
import com.jzj.pojo.Customer;
import com.jzj.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author Jzj
 * @Date 2022/3/15 23:15
 * @Version 1.0
 * @Message:
 */
@ContextConfiguration(classes = SpringDataJpaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringDataJpaTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testR(){
        Optional<Customer> byId = customerRepository.findById(2L);
        System.out.println(byId.get());
    }

    @Test
    public void testC(){
        Customer customer = new Customer();
        customer.setCustId(2L);
        customer.setCustName("bbb");
        customerRepository.save(customer);
    }

    @Test
    public void testBat(){
        Customer customer = new Customer();
        customer.setCustName("ccc");
        Customer customer2 = new Customer();
        customer.setCustName("ggg");
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer);
        customerRepository.saveAll(customers);
    }

    @Test
    public void testCc(){
        Customer customer = customerRepository.findById(2L).get();
        System.out.println(customer);
    }

    @Test
    public void testEx(){
        boolean flag = customerRepository.existsById(2L);
        System.out.println(flag);
    }

    @Test
    public void testAll(){
        ArrayList<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);
        List<Customer> all =(List<Customer>) customerRepository.findAllById(list);
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    @Test
    public void testPage(){
        Page<Customer> all = customerRepository.findAll(PageRequest.of(0, 2));
        List<Customer> content = all.getContent();
        System.out.println(all.getTotalPages());
    }

    @Test
    public void testSort(){
        Sort sort = Sort.by("custId").descending();
        List<Customer> all = (List<Customer>) customerRepository.findAll(sort);
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    @Test
    public void testSorts(){
        Sort.TypedSort<Customer> sortType = Sort.sort(Customer.class);
        Sort sort = sortType.by(Customer::getCustId).descending();
        Iterable<Customer> all = customerRepository.findAll(sort);
    }

    @Test
    public void testSort11(){
        List<Customer> list = customerRepository.findCustomerByCustName("张三");
        System.out.println(list);
    }

    @Test
    public void testUpdateJQL(){
        customerRepository.updateCustomer("六点",2L);
    }
}
