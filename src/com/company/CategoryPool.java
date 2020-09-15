package com.company;

import java.util.*;

public class CategoryPool {

    private static CategoryPool instance;
    private Map<String, Map.Entry<String, List<Category>>> categoryPoolMap;

    private CategoryPool(){
        categoryPoolMap = new HashMap<>();
    }

    public static CategoryPool getInstance(){
        if(instance == null){
            instance = new CategoryPool();
        }

        return instance;
    }

    public void addToMap( Category addedCategory ) {
        List<Category> childList = new ArrayList<>();
        categoryPoolMap.put( addedCategory.getCategoryTitle(), new AbstractMap.SimpleEntry<>("0", childList));
    }

    public void addToMap( Category addedCategory, List<Category> childList ) {
        categoryPoolMap.put( addedCategory.getCategoryTitle(), new AbstractMap.SimpleEntry<>("0", childList));
    }

    public void addToMap(Category parent, Category addedCategory ) {
        List<Category> childList = new ArrayList<>();
        if( findRelatedParentedItem(parent) != null ) {
            findRelatedParentedItem(parent).getValue().add(addedCategory);
        }
        categoryPoolMap.put( addedCategory.getCategoryTitle(), new AbstractMap.SimpleEntry<>(addedCategory.getCategoryTitle(), childList));

    }

    public void addToMap( Category addedCategory, Category parent, List<Category> childList ) {

        categoryPoolMap.put( addedCategory.getCategoryTitle(), new AbstractMap.SimpleEntry<>(parent.getCategoryTitle(), childList));
    }

    public  List<Category> foundAllChildCategories( Category category, List<Category> concludedCategories ) {
        Map.Entry<String, List<Category>> foundCategory = findRelatedParentedItem(category);
        if( foundCategory != null ) {
            if(!foundCategory.getValue().isEmpty()) {
                for( int i = 0; i<foundCategory.getValue().size(); i++){
                    if( !concludedCategories.contains( foundCategory.getValue().get(i))) {
                        concludedCategories.add(foundCategory.getValue().get(i));
                    }
                    else{
                        continue;
                    }
                    foundAllChildCategories( foundCategory.getValue().get(i), concludedCategories);
                }
            }
            else {
                if( !concludedCategories.contains( category )) {
                    concludedCategories.add(category);
                }
            }
        }
        return concludedCategories;
    }


    public Map<String, Map.Entry<String, List<Category>>> getCategoryPoolMap() {
        return categoryPoolMap;
    }

    public Map.Entry<String, List<Category>> findRelatedParentedItem( Category current ) {
        return categoryPoolMap.get( current.getCategoryTitle() );
    }

    public void addChild( Map.Entry<String, List<Category>> pair, Category child) {
      pair.getValue().add(child);
    }

}
