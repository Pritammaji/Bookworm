package com.vita.bookworm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vita.bookworm.Models.ProductMaster;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
    // @Query(value = "select * from product_master where :typeid = type_id or
    // product_english_name LIKE concat('%', :pname, '%') or :langid = language_id
    // or :genreid = genre_id", nativeQuery = true)

    // List<ProductMaster> getProduct(@Param("typeid") Integer typeid,
    // @Param("pname") String pname,
    // @Param("langid") Integer langid,
    // @Param("genreid") Integer genreid);
    @Query(value = "select * from product_master", nativeQuery = true)
    public List<ProductMaster> getAllProducts();

}
