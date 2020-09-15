package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Category implements CategoryIfc {

    private String title;
    public CategoryManager manager;
    public CategoryPool pool = CategoryPool.getInstance();
    List<Product> productList = new ArrayList<>();


    public Category ( String title ){
        this.title = title;
        this.manager = new CategoryManager();
        this.manager.setParent( null, this );
        this.manager.setChild( null );
        pool.addToMap( this );
    }

    public Category ( String title, Category parent ){
        this.title = title;
        this.manager = new CategoryManager();
        this.manager.setParent( parent, this );
        parent.manager.setChild( this );
        pool.addToMap( parent, this );
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public void addProduct( Product product) {
        productList.add( product );
    }

    @Override
    public String getCategoryTitle() {
        return title;
    }
}
