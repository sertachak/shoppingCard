package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private static Cart testCart;
    private static Product product1;
    private static Product product2;
    private static Product product3;
    private static Category testCategory1;
    private static Category testCategory2;
    private static Category testCategory3;

    @BeforeAll
    public static void setupTestObjs() throws Exception {
        testCart = new Cart();
        testCategory1 = new Category( "clothesCategory" );
        testCategory2 = new Category( "shoesCategory" );
        testCategory3 = new Category( "foodCategory" );
        product1 = new Product("shirt", 10, testCategory1);
        product2 = new Product("sneakers", 500, testCategory2);
        product3 = new Product("potato", 10, testCategory3);
    }

    @Test
    void addProductToCart() {
        testCart.addProductToCart(product1, 5);
        assertEquals(50, testCart.getTotalPrice());
        assertEquals(5, testCart.totalAmount);

        testCart.addProductToCart(product2, 2);
        assertEquals(1050, testCart.getTotalPrice());
        assertEquals(7, testCart.totalAmount);

        testCart.addProductToCart(product3, 20);
        assertEquals(1250, testCart.getTotalPrice());
        assertEquals(27, testCart.totalAmount);
    }
}