package com.company;

public class Coupon implements Discount{
    private final int minCartTotal;
    private final Cart cart;
    private final int coupon;

    public Coupon(int minCartTotal, Cart cart, int coupon) {
        this.minCartTotal = minCartTotal;
        this.cart = cart;
        this.coupon = coupon;
    }

    public void calculateDiscount(){
        if(cart.getTotalPrice() >= minCartTotal){
            float currentPrice = cart.getTotalPrice();
            if( !(currentPrice < coupon) )
                cart.setTotalPrice(currentPrice-coupon);
        }
    }
}