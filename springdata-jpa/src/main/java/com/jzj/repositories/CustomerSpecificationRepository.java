package com.jzj.repositories;

import com.jzj.pojo.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author Administrator
 * @Date 2022/3/16 14:46
 * @Version 1.0
 * @Message:
 */
public interface CustomerSpecificationRepository  extends CrudRepository<Customer,Long>, PagingAndSortingRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
}
