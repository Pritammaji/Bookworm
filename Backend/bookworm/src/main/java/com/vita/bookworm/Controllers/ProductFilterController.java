package com.vita.bookworm.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vita.bookworm.Controllers.Helper.FilterHelper;
import com.vita.bookworm.Models.ProductMaster;
import com.vita.bookworm.Service.ProductMasterService;

@RestController
public class ProductFilterController {

    ProductMasterService productMasterService;

    @Autowired
    public ProductFilterController(ProductMasterService productMasterService) {
        this.productMasterService = productMasterService;
    }

    @GetMapping("/search")
    public List<ProductMaster> search(@RequestBody FilterHelper filterHelper) {
        System.out.println(filterHelper);
        return productMasterService.geProduct(filterHelper);
    }
}
