package com.vita.bookworm.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.bookworm.Models.ProductMaster;
import com.vita.bookworm.Models.ShelfDetails;
import com.vita.bookworm.Repository.ShelfDetailsRepository;

@Service
public class ShelfDetailsService {
    @Autowired
    ShelfDetailsRepository shelfDetailsRepository;

    public List<ShelfDetails> getShelfDetails(int myShelfId) {
        return shelfDetailsRepository.findByShelfId(myShelfId);
    }

    public List<ProductMaster> getShelfProducts(int myShelfId) {
        List<ShelfDetails> shelfDetails = getShelfDetails(myShelfId);
        if (shelfDetails == null) {
            return new ArrayList<ProductMaster>();
        }
        List<ProductMaster> products = new ArrayList<ProductMaster>();
        for (ShelfDetails shelfDetail : shelfDetails) {
            products.add(shelfDetail.getProduct());
        }
        return products;
    }
}
