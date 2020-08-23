package com.kpq.store.product.service;

import com.kpq.store.product.entity.Category;
import com.kpq.store.product.entity.Product;
import com.kpq.store.product.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {


    private final IProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDb = getProduct(product.getId());
        if(productDb == null) return null;

        productDb.setName(product.getName());
        productDb.setDescription(product.getDescription());
        productDb.setCategory(product.getCategory());
        productDb.setPrice(product.getPrice());

        return productRepository.save(productDb);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = getProduct(id);
        if(product == null) return null;
        product.setStatus("DELETED");
        return productRepository.save(product);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product product = getProduct(id);
        if(product == null) return null;
        Double stock = product.getStock() + quantity;
        product.setStock(stock);
        return productRepository.save(product);
    }
}
