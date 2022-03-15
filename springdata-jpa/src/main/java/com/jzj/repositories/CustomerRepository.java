package com.jzj.repositories;

import com.jzj.pojo.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Jzj
 * @Date 2022/3/15 23:14
 * @Version 1.0
 * @Message:
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {

    @Query("from Customer where custName =:custName")
    List<Customer> findCustomerByCustName(@Param("custName") String custName);

    @Transactional
    @Modifying
    @Query("update Customer set custName=:custName where custId=:id")
    int updateCustomer(@Param("custName") String custName,@Param("id")Long id);
}
