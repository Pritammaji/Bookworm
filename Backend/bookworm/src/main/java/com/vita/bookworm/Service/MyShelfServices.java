package com.vita.bookworm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.bookworm.Models.MyShelf;
import com.vita.bookworm.Repository.MyShelfRepository;


@Service
public class MyShelfServices  {

    MyShelfRepository myShelfRepository;    

    @Autowired
    public MyShelfServices(MyShelfRepository myShelfRepository) {
        this.myShelfRepository = myShelfRepository;
    }

    public MyShelf addBook(MyShelf myShelf) {
        myShelf.setNoOfBooks(0);
        MyShelf m = myShelfRepository.save(myShelf);
        return m;
    }
}
