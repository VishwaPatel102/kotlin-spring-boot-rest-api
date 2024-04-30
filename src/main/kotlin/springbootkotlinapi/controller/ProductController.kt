package com.example.yourpackage

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController {

    private val products = listOf(
        Product(1, "Product 1"),
        Product(2, "Product 2")

    )

    @GetMapping
    fun getAllProducts(): List<Product> {
        return products
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): Product {
        return products.find { it.id == id } ?: throw Exception("Product not found")
    }
}
