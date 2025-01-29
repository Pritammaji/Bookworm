package com.vita.bookworm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.bookworm.Models.CustomerMaster;
import com.vita.bookworm.Models.MyShelf;
import com.vita.bookworm.Repository.CustomerMasterRepo;

import jakarta.transaction.Transactional;

@Service
public class CustomerMasterServices {
    CustomerMasterRepo customerMasterRepo;
    
    @Autowired
    MyShelfServices myShelfServices;

    public void setMyShelfServices(MyShelfServices myShelfServices) {
        this.myShelfServices = myShelfServices;
    }

    @Autowired
    public CustomerMasterServices(CustomerMasterRepo customerMasterRepo) {
        this.customerMasterRepo = customerMasterRepo;
    }

    public CustomerMaster checkUser(CustomerMaster c) {
        CustomerMaster c1 = customerMasterRepo.findByEmailAndPassword(c.getCustomerEmail() , c.getCustomerPassword());
        return c1;
    }

    @Transactional
    public CustomerMaster registerUser(CustomerMaster c) {
        CustomerMaster c1 = customerMasterRepo.save(c);

        MyShelf m = new MyShelf();
        m = myShelfServices.addBook(m);
        c1.setShelfId(m);

        return c1;
    }
}
