package com.company;

import java.util.List;

public interface CategoryIfc {
    List<Product> getProducts();
    void addProduct( Product product);
    String getCategoryTitle();
}
