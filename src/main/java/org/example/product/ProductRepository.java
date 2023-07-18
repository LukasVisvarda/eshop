package org.example.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void createProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId() == updatedProduct.getId()) {
                productList.set(i, updatedProduct);
                return;
            }
        }
    }

    public void deleteProduct(long id) {
        productList.removeIf(product -> product.getId() == id);
    }
}
