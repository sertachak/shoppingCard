package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryManager {

    public Category category;
    public Category parent;
    public CategoryPool pool = CategoryPool.getInstance();
    List<Category> childCategories = new ArrayList<>();

    public void setChild( Category child ) {
        childCategories.add( child );
    }

    public void setParent( Category parent, Category master ) {
        this.parent = parent;
        category = master;
    }

    public Category getParentCategory() {
        return parent;
    }

    public List<Category> getChildCategories() {
        return childCategories;
    }

}
