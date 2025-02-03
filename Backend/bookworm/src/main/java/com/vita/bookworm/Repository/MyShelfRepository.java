package com.vita.bookworm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vita.bookworm.Models.MyShelf;

@Repository
public interface MyShelfRepository extends JpaRepository<MyShelf, Integer> {
    
}
