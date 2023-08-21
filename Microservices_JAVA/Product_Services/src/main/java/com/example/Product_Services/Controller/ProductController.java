package com.example.Product_Services.Controller;

import com.example.Product_Services.DTO.ProductRequest;
import com.example.Product_Services.DTO.ProductResponse;
import com.example.Product_Services.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping("/findAll")
    public List<ProductResponse> findall(){
       return productService.returnAll();
    }

}
