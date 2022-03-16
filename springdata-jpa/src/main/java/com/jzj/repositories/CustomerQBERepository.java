package com.jzj.repositories;

import com.jzj.pojo.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * @Author Administrator
 * @Date 2022/3/16 12:15
 * @Version 1.0
 * @Message:
 */
public interface CustomerQBERepository extends CrudRepository<Customer,Long>, QueryByExampleExecutor<Customer> {
}
