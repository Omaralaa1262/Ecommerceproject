package com.example.ecommerceproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.Categories;
import model.Products;
import model.User_Details;


public class Ecommercehelper extends SQLiteOpenHelper {
    private static String Database_Name="Ecommerce";
    private  String UserTableName = "USER";
    private  String CategoryTableName = "CATEGORY";
    private  String OrderTableName = "ORDER_Table";
    private  String ProductTableName = "PRODUCT";
    private  String OrderDetalsTableName = "ORDERDETAILS";

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
    private  String ColumnID = "id";
    private  String ColumnUsername = "username";
    private  String ColumnFirstName = "firstname";
    private  String ColumnLastName = "lastname";
    private  String Columnbirthday = "birthday";
    private  String Columngender = "gender";
    private  String ColumnPassword = "password";
    private  String ColumnEmail = "email";
    private  String ColumnMobile = "mobile";
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
    private  String CategoryCAT_IDColumn = "CAT_ID";
    private  String CategoryCAT_NAMEColumn = "CAT_NAME";
    ////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

    private  String OrderORDER_IDColumn = "ORDER_ID";
    private  String OrderUSER_IDColumn = "USER_ID";
    private  String OrderORDER_DATEColumn = "ORDER_DATE";
    private  String OrderADDRESSColumn = "ADDRESS";
    ////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

    private  String ProductsPRO_IDColumn = "PRO_ID";
    private  String ProductsPRO_NAMEColumn = "PRO_NAME";
    private  String ProductsPRICEColumn = "PRICE";
    private  String ProductsQUANTITYColumn = "QUANTITY";
    private  String ProductsCATIDColumn = "CATID";
    ////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

    private  String Orderdetails_ORDERDETAILS_IDColumn = "ORDERDETAILS_ID";
    private  String OrderdetailsITEM_QUANTITYColumn = "ITEM_QUANTITY";
    private  String OrderdetailsORDERIDColumn = "ORDERID";
    private  String OrderdetailsPRODUCTIDColumn = "PRODUCTID";
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Table User Queries
    public   String CreateQueryUserTable = "CREATE TABLE IF NOT EXISTS " + UserTableName +
            " ( "
            + ColumnID + " INTEGER PRIMARY KEY autoincrement ,"
            + ColumnUsername + " TEXT,"
            + ColumnFirstName + " TEXT,"
            + ColumnLastName + " TEXT,"
            + Columnbirthday + " TEXT,"
            + Columngender + " TEXT,"
            + ColumnPassword + " TEXT,"
            + ColumnEmail + " TEXT,"
            + ColumnMobile + " TEXT)";
    public String DeleteUserTableQuery = "DROP TABLE IF EXISTS " + UserTableName;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Category Table Queries
    public String CreateCategoryTable=  "CREATE TABLE IF NOT EXISTS " + CategoryTableName +
            " ( "
            +"CAT_ID INTEGER PRIMARY KEY autoincrement,CAT_NAME TEXT)";
    public String DeleteCategoryTableQuery = "DROP TABLE IF EXISTS " + CategoryTableName;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Order Table Queries
    public String CreateOrderTable="CREATE TABLE IF NOT EXISTS " + OrderTableName+
            " ( "
            +"ORDER_ID INTEGER PRIMARY KEY autoincrement,USER_ID INTEGER,ORDER_DATE TEXT,ADDRESS TEXT"
            +",FOREIGN KEY(USER_ID) REFERENCES "+ UserTableName+
            "(id))";
    public String DeleteOrderTableQuery = "DROP TABLE IF EXISTS " + OrderTableName;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Product Table Queries
    public String CreateProductTable= "CREATE TABLE IF NOT EXISTS "+ ProductTableName+
            " ( "
            +"PRO_ID INTEGER PRIMARY KEY autoincrement "
            +",PRO_NAME TEXT,PRICE TEXT,QUANTITY TEXT,CATID INTEGER"
            +",FOREIGN KEY(CATID) REFERENCES "+CategoryTableName+"(CAT_ID))";
    public String DeleteProductTableQuery = "DROP TABLE IF EXISTS " + ProductTableName;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Order Details Table Queries
    public String CreateOrderDetailsTable ="CREATE TABLE IF NOT EXISTS "+ OrderDetalsTableName+
            " ( "
            +"ORDERDETAILS_ID INTEGER PRIMARY KEY autoincrement"
            +",ITEM_QUANTITY TEXT,ORDERID INTEGER,PRODUCTID INTEGER"
            +",FOREIGN KEY(ORDERID)REFERENCES "+OrderTableName+"(ORDER_ID)"
            +",FOREIGN KEY(PRODUCTID) REFERENCES "+ ProductTableName+"(PRO_ID))";
    public String DeleteOrderDetailsTableQuery = "DROP TABLE IF EXISTS " + OrderDetalsTableName;
    ////////////////////////////////////////////////////////////////////////////////////////////////

    SQLiteDatabase ecommerccDB;
    public Ecommercehelper(Context context){
        super(context,Database_Name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {   db.execSQL(CreateQueryUserTable);
        db.execSQL(CreateCategoryTable);
        //db.execSQL("insert into "+CategoryTableName+"("+CategoryCAT_NAMEColumn+")VALUES('TVs')");
        db.execSQL(CreateOrderDetailsTable);
        db.execSQL(CreateProductTable);
        db.execSQL(CreateOrderTable);


        Products Product;
        Categories Category;
        ContentValues Values = new ContentValues();
        Category =new Categories("TVs");
        Values.put(CategoryCAT_NAMEColumn,Category.CategoryName);
        db.insert(CategoryTableName, null, Values);
        //Insert_newCategory(Category,db);
        Category =new Categories("Watches");
        Insert_newCategory(Category,db);
        Category =new Categories("Mobiles");
        Insert_newCategory(Category,db);
        Category =new Categories("Electronics");
        Insert_newCategory(Category,db);
        Category =new Categories("Kitchen");
        Insert_newCategory(Category,db);
        Product =new Products("Samsung 50 inch","6899","5",1,"56655558");
        Insert_newProduct(Product,db);
        Product =new Products("LG 50 inch","6499","6",1,"65986588");
        Insert_newProduct(Product,db);
        Product =new Products("Toshiba Smart LED 43 inch","5999","10",1,"54668129");
        Insert_newProduct(Product,db);
        Product =new Products("Fresh 32inch LED HD Smart Android","2500","6",1,"64689665");
        Insert_newProduct(Product,db);
        Product =new Products("Samsung Galaxy M11 32GB","2099","20",2,"5646565");
        Insert_newProduct(Product,db);
        Product =new Products("Relme C15","2990","1",2,"4564645");
        Insert_newProduct(Product,db);
        Product =new Products("infinix Note 5 32GB","2333","5",2,"5665546");
        Insert_newProduct(Product,db);
        Product =new Products("Apple iphone 12 pro max 256GB","24957","1",2,"8598988");
        Insert_newProduct(Product,db);
        Product =new Products("Apple iphone 11 128 GB","14444","0",2,"6565656");
        Insert_newProduct(Product,db);
        Product =new Products("Apple iphone 12 pro","16969","2",2,"5466665");
        Insert_newProduct(Product,db);
        Product =new Products("Samsung Galaxy S20","12998","5",2,"6565664210");
        Insert_newProduct(Product,db);
        Product =new Products("JAC Microwave","1499","1",3,"65656");
        Insert_newProduct(Product,db);
        Product =new Products("Akai Stand Fan","459","0",3,"6546665");
        Insert_newProduct(Product,db);
        Product =new Products("kiriazy freezer 5 drawers","6899","2",3,"987556465");
        Insert_newProduct(Product,db);
        Product =new Products("Kenwood ceramic steam iron","560","45",3,"54665665");
        Insert_newProduct(Product,db);
        Product =new Products("Mienta Hot plate small flame 500Watt","218","50",3,"6556660");
        Insert_newProduct(Product,db);
        Product =new Products("Home Stand Mixer 1200Watt","2498","2",4,"6656665688");
        Insert_newProduct(Product,db);
        Product =new Products("Fresh Elshaba7 Blender","324","10",4,"6856866");
        Insert_newProduct(Product,db);
        Product =new Products("Braun Hand Blender","1749","55",4,"56565658");
        Insert_newProduct(Product,db);










    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DeleteUserTableQuery);
        db.execSQL(DeleteCategoryTableQuery);
        db.execSQL(DeleteOrderDetailsTableQuery);
        db.execSQL(DeleteProductTableQuery);
        db.execSQL(DeleteOrderTableQuery);
        onCreate(db);
    }
    public User_Details Authenticate(User_Details user)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(UserTableName, new String[]
                        { ColumnID,ColumnUsername ,ColumnFirstName,ColumnLastName,Columnbirthday,Columngender, ColumnEmail,ColumnPassword,ColumnMobile },
                ColumnUsername + "=?", new String[] { user.Username }, null, null, null);
        if(cursor != null && cursor.moveToFirst() && cursor.getCount() > 0)
        {
            User_Details user1 = new User_Details(cursor.getString(7));
            if (user.Password.equalsIgnoreCase(user1.Password)){
                return user1;

            }
        }
        return null;
    }
    public void Register( User_Details user)
    {
        ContentValues Values = new ContentValues();
        Values.put(ColumnUsername, user.Username);
        Values.put(ColumnFirstName, user.FirstName);
        Values.put(ColumnLastName, user.LastName);
        Values.put(Columnbirthday, user.birthday);
        Values.put(Columngender, user.gender);
        Values.put(ColumnPassword, user.Password);
        Values.put(ColumnEmail, user.Email);
        Values.put(ColumnMobile, user.Mobile);
        ecommerccDB=getWritableDatabase();
        ecommerccDB.insert(UserTableName, null, Values);
        ecommerccDB.close();
    }
    public void  Insert_newCategory(Categories category,SQLiteDatabase db){
        ContentValues Values = new ContentValues();
        Values.put(CategoryCAT_NAMEColumn,category.CategoryName);
        db.insert(CategoryTableName, null, Values);
    }
    public void Insert_newProduct(Products Products,SQLiteDatabase db){
        ContentValues Values = new ContentValues();
        Values.put(ProductsPRO_NAMEColumn,Products.ProName);
        Values.put(ProductsPRICEColumn,Products.ProPrice);
        Values.put(ProductsQUANTITYColumn,Products.ProQuantity);
        Values.put(ProductsCATIDColumn,(Integer)Products.Pro_CatID);
        db.insert(ProductTableName, null, Values);
    }

}

