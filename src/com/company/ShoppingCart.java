package com.company;

public class ShoppingCart {

    public static void main(String[] args) {
        Category clothes = new Category("clothes");
        Category shoes = new Category( "shoes", clothes);
        Category bags = new Category( "bags", shoes);
        Category paints = new Category( "paints", shoes);

        Category watches = new Category( "watches", clothes);

        Category bracelets = new Category( "bracelets", clothes);
        Category hat = new Category( "hat", clothes);


        Product shirt = new Product("shirt", (float) 9.99, clothes);
        Product tshirt = new Product("tshirt", (float) 9.99, clothes);
        Product sneaker = new Product("sneaker", (float) 9.99, clothes );
        Cart shoppingCart = new Cart();

        int shirtQuantity =  10;
        shoppingCart.addProductToCart(shirt, shirtQuantity);
        System.out.println("Shirt is added to cart. Price: " + shirt.getPrice() + "$, Quantity: " + shirtQuantity);
        System.out.println("Your cart has " + shoppingCart.totalAmount + " items. Total price: " + shoppingCart.getTotalPrice() + "$.");

        int tshirtQuantity = 5;
        shoppingCart.addProductToCart(tshirt, tshirtQuantity);
        System.out.println("T-Shirt is added to cart. Price: " + tshirt.getPrice() + "$, Quantity: " + tshirtQuantity);
        System.out.println("Your cart has " + shoppingCart.totalAmount + " items. Total price: " + shoppingCart.getTotalPrice() + "$.");

        int sneakerQuantity = 2;
        shoppingCart.addProductToCart(sneaker, sneakerQuantity);
        System.out.println("Sneaker is added to cart. Price: " + sneaker.getPrice() + "$, Quantity: " + sneakerQuantity);
        System.out.println("Your cart has " + shoppingCart.totalAmount + " items. Total price: " + shoppingCart.getTotalPrice() + "$.");

        int campaignProductAmount = 10;
        Discount clothesCampaign = new Campaign(clothes, shoppingCart, 50, campaignProductAmount);
        System.out.println("You have a campaign with category '" + clothes.getCategoryTitle() + "' for " + campaignProductAmount + " items.");
        System.out.println("Total price before campaign: " + shoppingCart.getTotalPrice());
        clothesCampaign.calculateDiscount();
        System.out.println("Total price after campaign: " +shoppingCart.getTotalPrice());

        int couponValue = 20;
        int minCartTotal = 10;
        Discount coupon = new Coupon( minCartTotal, shoppingCart, couponValue );
        System.out.println("You have a coupon with value of " + couponValue + "$. Total price of your cart must have at least " + minCartTotal + "$.");
        coupon.calculateDiscount();
        System.out.println("Total price after coupon is activated: " + shoppingCart.getTotalPrice());

        Category jewels = new Category("jewels");
        Product ring = new Product("ring", 20, jewels);
        int ringQuantity = 5;
        shoppingCart.addProductToCart(ring, ringQuantity);
        System.out.println("Ring is added to cart. Price: " + ring.getPrice() + "$, Quantity: " + ringQuantity);
        System.out.println("Your cart has " + shoppingCart.totalAmount + " items. Total price: " + shoppingCart.getTotalPrice() + "$.");

        DeliveryCost deliveryCost = new DeliveryCost(shoppingCart);
        int totalDeliveryCost = deliveryCost.calculateDeliveryCost();
        System.out.println("Total delivery cost: " + totalDeliveryCost);
        System.out.println("Total cost with delivery: " + shoppingCart.getTotalPrice());
    }
}
