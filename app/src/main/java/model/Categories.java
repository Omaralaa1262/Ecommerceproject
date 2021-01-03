package model;

public class Categories {
    public String Cat_ID;
    public String CategoryName;
    public Categories( String Cat_ID,String CategoryName){
        this.Cat_ID=Cat_ID;
        this.CategoryName=CategoryName;
    }
    public Categories(String CategoryName){

        this.CategoryName=CategoryName;
    }


    public String getCat_ID() {
        return Cat_ID;
    }

    public void setCat_ID(String cat_ID) {
        Cat_ID = cat_ID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
