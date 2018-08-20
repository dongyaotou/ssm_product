package cn.nb.dao;

import cn.nb.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    //查询商品表中的所有商品的信息
    public List<Product> findAllProduct();


   //从数据库中查看库存量，是否减少
    public int findQuantity(Integer id);

    //通过用户选择的商品获取商品的id
    public int findIdByProductName(String name);


    //更新数据库中的库存量
    public void updateQuantity(@Param("quantity") Integer stock,@Param("id") int id);




}
