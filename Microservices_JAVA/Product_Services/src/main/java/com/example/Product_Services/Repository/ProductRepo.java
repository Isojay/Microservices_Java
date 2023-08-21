package com.example.Product_Services.Repository;

import com.example.Product_Services.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {



}
