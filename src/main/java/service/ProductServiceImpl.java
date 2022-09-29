package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{

    private static Map<Integer, Product> products;
    List<Product> foundProduct=new ArrayList<>();
    static {

        products = new HashMap<>();
        products.put(1, new Product(1,"Cam",20000,"cùng họ với quýt","vườn trồng Hòa Bình"));
       products.put(2, new Product(2,"rau cải đắng",12000,"vị đắng rất phù hợp để hối cải","hợp tác xã khuyến nông"));
       products.put(3, new Product(3,"rau bắp cải",15000,"phù hợp ăn vào mùa đông","công ty rau củ quả đông xuân"));
       products.put(4, new Product(4,"rau muống",10000,"không ăn khi cuống quýt","mương xanh"));
       products.put(5, new Product(5,"dưa muối",9000,"có thể ăn thay cà muối","nhà làm"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        foundProduct.clear();
        for (Product product: products.values()) {
            if(product.getName().contains(name)){
                foundProduct.add(product);
            }

        }
        return (ArrayList<Product>) foundProduct;
    }
}