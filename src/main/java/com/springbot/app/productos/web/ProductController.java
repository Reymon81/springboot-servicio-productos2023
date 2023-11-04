package com.springbot.app.productos.web;

import com.springbot.app.productos.models.Product;
import com.springbot.app.productos.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/productos/listar")
    ResponseEntity<List<Product>> getProductList(){

        var response = service.findAll();

        return (Objects.nonNull(response))
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/productos/mostrar/{id}")
    ResponseEntity<Product> getProduct(@PathVariable Long id){

        var response = service.findById(id);

        return (Objects.nonNull(response)) ?
                new ResponseEntity<>(response, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
