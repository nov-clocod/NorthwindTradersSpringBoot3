package com.pluralsight.NorthwindTraders3.services;

import com.pluralsight.NorthwindTraders3.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTraders3.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private IProductDAO productDAO;

    @Autowired
    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDAO.getProductByID(productId);
    }

    public void updateProduct(int productId, Product product) {
        productDAO.update(productId, product);
    }

    public void deleteProduct(int productId) {
        productDAO.delete(productId);
    }
}
