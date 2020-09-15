package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryCost {
    private final Cart cart;

    public DeliveryCost(Cart cart) {
        this.cart = cart;
    }

    public int calculateDeliveryCost(){
        int totalDeliveryCost = 0;
        HashMap<Product, Integer> cartElements = this.cart.getCartList();
        List<Category> categoryList = new ArrayList<>();
        for (Map.Entry<Product, Integer> pair : cartElements.entrySet()) {
            Product product = pair.getKey();
            if(!categoryList.contains(product.getCategory())){
                categoryList.add(product.getCategory());
                totalDeliveryCost += 5;
            }
            int productQuantity = pair.getValue();
            if(productQuantity >= 10){
                totalDeliveryCost += .5F*productQuantity;
            }
        }
        this.cart.setTotalPrice(this.cart.getTotalPrice() + totalDeliveryCost);
        return totalDeliveryCost;
    }
}