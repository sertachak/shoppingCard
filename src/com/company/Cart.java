package com.company;

import java.util.*;

public class Cart {
    private float totalPrice;
    public int totalAmount;

    private HashMap<Product, Integer> cartList = new HashMap<>();

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HashMap<Product, Integer> getCartList() {
        return cartList;
    }

    public void setCartList(HashMap<Product, Integer> cartList) {
        this.cartList = cartList;
    }

    public void addProductToCart(Product product, int quantity){
        if(cartList.containsKey(product)){
            int productCurrentQuantity = cartList.get(product);
            productCurrentQuantity += quantity;
            cartList.put(product, productCurrentQuantity);
            totalPrice += product.getPrice()*quantity;
            totalAmount += quantity;
        }
        else{
            cartList.put(product, quantity);
            totalPrice += product.getPrice()*quantity;
            totalAmount += quantity;
        }
    }

}