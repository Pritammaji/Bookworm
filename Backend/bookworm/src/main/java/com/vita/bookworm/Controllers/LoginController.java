package com.vita.bookworm.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vita.bookworm.Models.CustomerMaster;
import com.vita.bookworm.Service.CustomerMasterServices;

@RestController
public class LoginController {
    CustomerMasterServices customerMasterServices;

    @Autowired
    public LoginController(CustomerMasterServices customerMasterServices) {
        this.customerMasterServices = customerMasterServices;
    }

    @GetMapping("/login")
    public  CustomerMaster login(@RequestBody CustomerMaster c) {
        return customerMasterServices.checkUser(c);
    }

    @PostMapping("/register")
    public CustomerMaster register(@RequestBody CustomerMaster c) {
        if (customerMasterServices.checkUserExists(c)) {
            return null;
        }
        return customerMasterServices.registerUser(c);
    }
}
