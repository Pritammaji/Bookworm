package com.vita.bookworm.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.vita.bookworm.Models.ProductMaster;
import com.vita.bookworm.Service.MyShelfServices;

@RestController
public class MyShelfController {
    @Autowired
    public MyShelfServices myShelfServices;

    public List<ProductMaster> getShelfProducts(int myShelfId) {
        return null;
    }
}
