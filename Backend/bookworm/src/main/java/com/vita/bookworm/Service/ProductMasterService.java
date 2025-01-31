package com.vita.bookworm.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.bookworm.Controllers.Helper.FilterHelper;
import com.vita.bookworm.Models.AuthorMaster;
import com.vita.bookworm.Models.ProductMaster;
import com.vita.bookworm.Repository.ProductMasterRepository;



@Service
public class ProductMasterService {
    @Autowired
    private ProductMasterRepository productMasterRepository;

    @Autowired
    private AuthorService authorService;

    public ProductMaster getProductById(int id) {
        return productMasterRepository.findById(id).orElse(null);
    }

    public List<ProductMaster> geProduct(FilterHelper filter) {
        List<ProductMaster> products = productMasterRepository.getProduct(filter.getTypeId(), filter.getProductName(),filter.getLangId(), filter.getGenreId());    
        if (filter.getAuthorName() != null){
            Stream t = products.stream().filter(product -> product.getProductAuthor().getAuthorName().contains(filter.getAuthorName()));
            products = t.toList();
            t.close();
        }
        return products;
    }

    public List<ProductMaster> getAllProducts() {
        return productMasterRepository.findAll();
    }

    public ProductMaster addProduct(ProductMaster product) {
        return productMasterRepository.save(product);
    }

    public ProductMaster updateProduct(ProductMaster product) {
        return productMasterRepository.save(product);
    }

    public void deleteProduct(int id) {
        productMasterRepository.deleteById(id);
    }

    public List<ProductMaster> getProductByName(String name) {
        return productMasterRepository.findByName(name);
    }

    public List<ProductMaster> getProductByType(int type) {
        return productMasterRepository.findByType(type);
    }

    public List<ProductMaster> getProductByGenre(int genre) {
        return productMasterRepository.findByGenre(genre);
    }

    public List<ProductMaster> getProductByLanguage(int language) {
        return productMasterRepository.findByLanguage(language);
    }

    public List<ProductMaster> getProductByAuthorName(String authorName) {
        List<AuthorMaster> a = authorService.getAuthorByName(authorName);
        List<ProductMaster> products = new ArrayList<>();
        for (AuthorMaster author : a) {
            products.addAll(productMasterRepository.findByAuthorId(author.getAuthorId()));
        }
        return products;
    }
}
