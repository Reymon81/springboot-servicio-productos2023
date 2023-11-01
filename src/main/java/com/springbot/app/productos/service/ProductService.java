package com.springbot.app.productos.service;

import com.springbot.app.productos.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);
}
