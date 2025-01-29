package com.vita.bookworm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vita.bookworm.Models.MyShelf;

public interface MyShelfRepository extends JpaRepository<MyShelf, Integer> {
    
}
