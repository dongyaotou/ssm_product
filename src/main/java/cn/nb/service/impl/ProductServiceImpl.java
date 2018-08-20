package cn.nb.service.impl;

import cn.nb.bean.Product;
import cn.nb.dao.ProductMapper;
import cn.nb.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService{

@Resource
private  ProductMapper productMapper;//dao层的调用

    @Override
    public List<Product> findAllProduct() {
        System.out.println("ProductServiceImpl====>findAllProduct");

        return productMapper.findAllProduct();
    }

    @Override
    public int findQuantity(Integer id) {
        System.out.println("ProductServiceImpl====>findQuantity");
        return productMapper.findQuantity(id);
    }

    @Override
    public int findIdByProductName(String name) {
        System.out.println("ProductServiceImpl====>findIdByProductName");
        return productMapper.findIdByProductName(name);
    }

    @Override
    public void updateQuantity(Integer stock, int id) {
        System.out.println("ProductServiceImpl====>updateQuantity");
        productMapper.updateQuantity(stock,id);
    }


}
