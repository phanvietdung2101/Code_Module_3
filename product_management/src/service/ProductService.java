package service;
import model.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);

    void editById(int id, String name, String category, String description, double price);

    void removeById(int id);
    Product findById(int id);
    List<Product> findAll();
}
