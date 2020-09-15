package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryCostTest {

    private static Cart testCart;
    private static Product product1;
    private static Product product2;
    private static Product product3;
    private static Category testCategory1;
    private static Category testCategory2;
    private static Category testCategory3;
    private static DeliveryCost deliveryCost;

    @BeforeAll
    public static void setupTestObjs() throws Exception {
        testCart = new Cart();
        testCategory1 = new Category( "clothesCategory" );
        testCategory2 = new Category( "shoesCategory" );
        testCategory3 = new Category( "foodCategory" );
        product1 = new Product("shirt", 10, testCategory1);
        product2 = new Product("sneakers", 500, testCategory2);
        product3 = new Product("potato", 10, testCategory3);
        deliveryCost = new DeliveryCost(testCart);
    }

    @Test
    void calculateDeliveryCost() {
        testCart.addProductToCart(product1, 5);
        testCart.addProductToCart(product2, 2);
        testCart.addProductToCart(product3, 15);
        double totalCartPrice = testCart.getTotalPrice();
        int totalDelivery = deliveryCost.calculateDeliveryCost();
        assertEquals(22, totalDelivery);
        assertEquals(totalCartPrice + totalDelivery, testCart.getTotalPrice());
    }
}