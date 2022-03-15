package com.jzj.pojo;


import lombok.Data;

import javax.persistence.*;

/**
 * @Author Jzj
 * @Date 2022/3/15 19:13
 * @Version 1.0
 * @Message:
 */
@Data
@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;
}
