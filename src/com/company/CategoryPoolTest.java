package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryPoolTest {

    private static CategoryPool pool;
    public static List<Category> concludedCategories;

    @BeforeAll
    public static void setupTestObjs() throws Exception {
        pool = CategoryPool.getInstance();
        concludedCategories = new ArrayList<>();
    }

    @Test
    void foundAllChildCategories() {
        Category clothes = new Category("clothes");
        Category shoes = new Category( "shoes", clothes);
        Category bags = new Category( "bags", shoes);
        Category paints = new Category( "paints", shoes);

        Category watches = new Category( "watches", clothes);

        Category bracelets = new Category( "bracelets", clothes);
        Category hat = new Category( "hat", clothes);

        List<Category> returnedList = pool.foundAllChildCategories( clothes, concludedCategories );
        assertEquals(6, returnedList.size());

    }

    @Test
    void findRelatedParentedItem() {

        Category clothes = new Category("clothes");
        Category shoes = new Category( "shoes", clothes);
        Category bags = new Category( "bags", shoes);
        Category paints = new Category( "paints", shoes);

        Map.Entry<String, List<Category>> relatedParentItem = pool.findRelatedParentedItem(shoes);
        assertEquals( 2, relatedParentItem.getValue().size());
    }
}