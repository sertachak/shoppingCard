package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {
    private static Cart testCart;
    private static Category testCategory1;
    private static Category testCategory2;
    private static Category testCategory3;

    @BeforeAll
    public static void setupTestObjs() throws Exception {
        testCart = new Cart();
        testCategory1 = new Category( "clothesCategory" );
        testCategory2 = new Category( "shoesCategory" );
        testCategory3 = new Category( "foodCategory" );
    }

    @Test
    void calculateDiscount(){
        Product product1 = new Product("shirt", 30, testCategory1);
        Product product2 = new Product("sneaker", 500, testCategory2);
        Product product3 = new Product("corn", 10, testCategory3);

        testCart.addProductToCart(product1, 2);
        testCart.addProductToCart(product2, 1);
        testCart.addProductToCart(product3, 10);
        float initialTotalPrice = testCart.getTotalPrice();
        System.out.println("total price: " + initialTotalPrice);

        int couponDiscount = 20;
        Discount testCoupon = new Coupon(100, testCart, couponDiscount);
        testCoupon.calculateDiscount();
        System.out.println("after discount: " + testCart.getTotalPrice());
        assertEquals(testCart.getTotalPrice(), initialTotalPrice-couponDiscount);
    }
}