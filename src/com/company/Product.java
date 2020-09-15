package com.company;

public class Product implements ProductIfc{
    private final String title;
    private float price;
    private final Category category;


    public Product(String title, float price, Category category) {
        super();
        this.title = title;
        this.price = price;
        this.category = category;
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice( float price ) {
        this.price = price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}