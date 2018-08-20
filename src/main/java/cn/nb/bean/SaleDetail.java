package cn.nb.bean;
//销售信息查询

import java.util.Date;

public class SaleDetail {
    private int id;
    private String product;
    private double price;
    private int quantity;
    private double totalPrice;
    private Date date;
    private String name;

    public SaleDetail() {
    }

    public SaleDetail(int id, String product, double price, int quantity, double totalPrice, Date date, String name) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "saleDetail{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
