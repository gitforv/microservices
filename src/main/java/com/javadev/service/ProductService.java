package com.javadev.service;

import com.javadev.dto.ProductRequest;
import com.javadev.dto.ProductResponse;
import com.javadev.model.Product;
import com.javadev.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

   /* public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

    public void createProduct(ProductRequest productRequest){


        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product {} is saved ", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products =  productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
