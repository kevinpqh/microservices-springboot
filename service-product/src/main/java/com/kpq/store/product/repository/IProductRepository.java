package com.kpq.store.product.repository;

import com.kpq.store.product.entity.Category;
import com.kpq.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
