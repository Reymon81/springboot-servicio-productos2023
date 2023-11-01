package com.springbot.app.productos.service.impl;

import com.springbot.app.productos.models.Product;
import com.springbot.app.productos.repository.ProductRepository;
import com.springbot.app.productos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Product> findAll() {

        return (List<Product>) repository.findAll();
    }

    @Override
    public Product findById(Long id) {

        return repository.findById(id).orElse(null);
    }
}
