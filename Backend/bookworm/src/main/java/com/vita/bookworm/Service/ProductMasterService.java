package com.vita.bookworm.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.bookworm.Controllers.Helper.FilterHelper;
import com.vita.bookworm.Models.ProductMaster;
import com.vita.bookworm.Repository.ProductMasterRepository;

@Service
public class ProductMasterService {
    ProductMasterRepository productMasterRepository;

    @Autowired
    public ProductMasterService(ProductMasterRepository productMasterRepository) {
        this.productMasterRepository = productMasterRepository;
    }

    /*
     * by name
     * by lang
     * by genre
     * by author
     */

    public ProductMaster getProductById(int id) {
        return productMasterRepository.findById(id).orElse(null);
    }

    public List<ProductMaster> geProduct(FilterHelper filter) {
        // if (filter.getProductName() != null)
        // filter.setProductName("%" + filter.getProductName() + "%");
        List<ProductMaster> t = productMasterRepository.getAllProducts();
        Stream<ProductMaster> temp = t.stream();
        if (filter.getTypeId() != null)
            temp = temp.filter(x -> x.getProductType() !=null &&  x.getProductType().getTypeId() == filter.getTypeId());
        if (filter.getProductName() != null)
            temp = temp.filter(x -> x.getProductEnglishName().contains(filter.getProductName()));
        if (filter.getLangId() != null)
            temp = temp.filter(x -> x.getProductLang() != null && x.getProductLang().getLanguageId() == filter.getLangId());
        if (filter.getGenreId() != null)
            temp = temp.filter(x -> x.getProductGenre() != null && x.getProductGenre().getGenreId() == filter.getGenreId());
        return temp.toList();
    }

}
