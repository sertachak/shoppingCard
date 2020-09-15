package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


import static org.junit.jupiter.api.Assertions.*;

class CampaignTest {
    private static Cart testCart;
    private static Category testCategory;

    @BeforeAll
    public static void setupTestObjs() throws Exception {
        testCart = new Cart();
        testCategory = new Category( "potatoCategory" );
    }

    @Test
    void calculateDiscount() throws Exception {
        Product p1 = new Product( "potato1", 20,testCategory );
        Product p2 = new Product( "potato2", 10,testCategory );
        testCart.addProductToCart( p1, 10);
        testCart.addProductToCart( p2, 10);
        Campaign campaign = new Campaign( testCategory, testCart, 20, 5 );
        assertEquals( 300, testCart.getTotalPrice() );
        campaign.calculateDiscount();
        assertEquals( 240, testCart.getTotalPrice() );
    }
}