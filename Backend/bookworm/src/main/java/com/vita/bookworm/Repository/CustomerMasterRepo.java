package com.vita.bookworm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vita.bookworm.Models.CustomerMaster;

public interface CustomerMasterRepo extends JpaRepository<CustomerMaster, Integer> {
    @Query(value = "SELECT * FROM customer_master c WHERE c.customer_email = :email and c.customer_password = :password" , nativeQuery = true)
    CustomerMaster findByEmailAndPassword(@Param("email") String email , @Param("password") String password);

}
