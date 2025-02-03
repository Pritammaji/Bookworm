package com.vita.bookworm.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.bookworm.Models.MyShelf;
import com.vita.bookworm.Models.ProductMaster;
import com.vita.bookworm.Repository.MyShelfRepository;


@Service
public class MyShelfServices  {
    MyShelfRepository myShelfRepository;    

    @Autowired
    ShelfDetailsService shelfDetailsService;
    
    @Autowired
    public MyShelfServices(MyShelfRepository myShelfRepository) {
        this.myShelfRepository = myShelfRepository;
    }

    public List<ProductMaster> getShelfProducts(int myShelfId) {
        return shelfDetailsService.getShelfProducts(myShelfId);
        
    }

    public MyShelf addBook(MyShelf myShelf) {
        myShelf.setNoOfBooks(myShelf.getNoOfBooks() + 1);
        MyShelf m = myShelfRepository.save(myShelf);
        return m;
    }
}
