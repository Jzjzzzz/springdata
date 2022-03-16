package com.jzj;

import com.jzj.config.SpringDataJpaConfig;
import com.jzj.pojo.Customer;
import com.jzj.repositories.CustomerSpecificationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;

/**
 * @Author Administrator
 * @Date 2022/3/16 14:48
 * @Version 1.0
 * @Message:
 */
@ContextConfiguration(classes = SpringDataJpaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaSpecificationExecutorTest {

    @Autowired
    CustomerSpecificationRepository customerRepository;

    @Test
    public void testR(){
        customerRepository.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //root 获取列
                Path<Object> custId = root.get("custId");
                Path<Object> custName = root.get("custName");
                Path<Object> custAddress = root.get("custAddress");
                Predicate address = criteriaBuilder.equal(custAddress, "北京");
                return address;
            }
        });
    }
}
