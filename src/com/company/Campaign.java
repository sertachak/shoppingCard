package com.company;

import java.util.*;

public class Campaign implements Discount{
    private final Category discountedProductCategory;
    private final Cart productCart;
    private final int discountPercent;
    private final int productAmountForDiscount;
    public CategoryPool pool = CategoryPool.getInstance();
    public List<Category> concludedCategories = new ArrayList<>();

    public Campaign(Category discountedProductCategory, Cart productCart, int discountPercent, int productAmount) {
        this.discountedProductCategory = discountedProductCategory;
        this.productCart = productCart;
        this.discountPercent = discountPercent;
        productAmountForDiscount = productAmount;
    }


    public void calculateDiscount(){
        HashMap<Product, Integer> cartList = productCart.getCartList();
        float discount = 0;
        concludedCategories.clear();
        List<Category> concludedCategoriesList = pool.foundAllChildCategories( discountedProductCategory, concludedCategories );
        concludedCategoriesList.add(discountedProductCategory);
        System.out.println( "Child Size " + concludedCategoriesList.size() );

        for (Map.Entry<Product, Integer> pair : cartList.entrySet()) {

            Product product = pair.getKey();
            if (concludedCategoriesList.contains( product.getCategory() )) {
                int productQuantity = pair.getValue();
                float price = product.getPrice();

                if( productQuantity >= productAmountForDiscount) {
                    discount =  (discountPercent * price / 100);
                }
                else if (productQuantity >= productAmountForDiscount/2) {
                    float halfOfDiscount = .5F;
                    discount = halfOfDiscount * discountPercent * price / 100;
                } else {
                    float quarterOfDiscount = .25F;
                    discount = quarterOfDiscount * discountPercent * price / 100;
                }
                System.out.println("Discount per item  " +  discount );
                product.setPrice( product.getPrice()- discount );
                productCart.setTotalPrice( productCart.getTotalPrice() - discount*productQuantity );
            }
        }
    }
}