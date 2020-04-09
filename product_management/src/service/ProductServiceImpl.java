package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> productList ;

    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"kem danh rang","Gia dung","Kem danh rang PS",38000));
        productList.put(2,new Product(2,"kem danh rang","Gia dung","Kem danh rang Colgate",30000));
        productList.put(3,new Product(3,"Ipad","May tinh bang","May tinh bang xin so",5));
        productList.put(4,new Product(4,"Galaxy S20","Dien thoai","galaxy",5));
        productList.put(5,new Product(5,"Iphone XS","Dien thoai","ip",5));
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public void editById(int id,String name,String category,String description,double price) {
        Product product = findById(id);
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);
    }

    @Override
    public void removeById(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<> (productList.values());
    }
}
