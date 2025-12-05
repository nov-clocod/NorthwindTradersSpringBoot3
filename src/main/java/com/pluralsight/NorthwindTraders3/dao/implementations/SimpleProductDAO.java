package com.pluralsight.NorthwindTraders3.dao.implementations;

import com.pluralsight.NorthwindTraders3.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTraders3.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements IProductDAO {
    private List<Product> products;

    public SimpleProductDAO() {
        this.products = new ArrayList<>();

        products.add(new Product(1, "Crab", 1, 34.99));
        products.add(new Product(2, "Egg", 2, 8.99));
        products.add(new Product(3, "Chicken", 3, 55.68));
    }

    @Override
    public Product addProduct(Product product) {
        int maxID = 0;

        for (Product p : products) {
            if (p.getProductId() > maxID) {
                maxID = p.getProductId();
            }
        }
        product.setProductId(maxID + 1);
        products.add(product);
        return product;
    }


    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductByID(int productID) {
        for (Product product : products) {
            if (product.getProductId() == productID) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int productID, Product product) {
        int index = getProductIndex(productID);
        if (index != -1) {
            products.set(index, product);
        }
    }

    @Override
    public void delete(int transactionId) {
        int index = getProductIndex(transactionId);
        if (index != -1) {
            products.remove(index);
        }
    }

    private int getProductIndex(int ProductID) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == ProductID) {
                return i;
            }
        }
        return -1;
    }
}
