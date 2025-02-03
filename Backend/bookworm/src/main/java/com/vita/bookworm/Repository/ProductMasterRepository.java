package com.vita.bookworm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vita.bookworm.Models.ProductMaster;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
    @Query(value = "select * from product_master where (:typeid is null or :typeid = type_id ) and (:pname is null or product_english_name LIKE concat('%', :pname, '%')) and (:langid is null or :langid = language_id ) and (:genreid is null or :genreid = genre_id)", nativeQuery = true)
    List<ProductMaster> getProduct(
            @Param("typeid") Integer typeid,
            @Param("pname") String pname,
            @Param("langid") Integer langid,
            @Param("genreid") Integer genreid);

    @Query(value = "select * from product_master", nativeQuery = true)
    List<ProductMaster> getAllProducts();

    @Query(value = "select * from product_master where product_english_name LIKE concat('%', :name, '%')", nativeQuery = true)
    List<ProductMaster> findByName(@Param("name") String name);

    @Query(value = "select * from product_master where type_id = :type", nativeQuery = true)
    List<ProductMaster> findByType(@Param("type") int type);

    @Query(value = "select * from product_master where genre_id = :genre", nativeQuery = true)
    List<ProductMaster> findByGenre(@Param("genre") int genre);

    @Query(value = "select * from product_master where language_id = :language", nativeQuery = true)
    List<ProductMaster> findByLanguage(@Param("language") int language);

    @Query(value = "select * from product_master where author_id = :author", nativeQuery = true)
    List<ProductMaster> findByAuthorId(@Param("author") int author);
}
