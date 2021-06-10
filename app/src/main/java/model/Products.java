package model;

public class Products {
    public int Pro_ID;
    public String ProName;
    public String ProPrice;
    public String ProQuantity;
    public int Pro_CatID;
    public int barcode;

    public Products( int Pro_ID, String ProName, String ProPrice, String ProQuantity, int Pro_CatID,int barcode)
    {
        this.Pro_ID=Pro_ID;
        this.Pro_CatID=Pro_CatID;
        this.ProName=ProName;
        this.ProPrice=ProPrice;
        this.ProQuantity=ProQuantity;
        this.barcode=barcode;
    }
    public Products(String ProName, String ProPrice, String ProQuantity, int Pro_CatID,int  barcode)
    {

        this.Pro_CatID=Pro_CatID;
        this.ProName=ProName;
        this.ProPrice=ProPrice;
        this.ProQuantity=ProQuantity;
        this.barcode=barcode;
    }
    public Products(int Pro_ID,String ProName, String ProPrice, String ProQuantity)
    {
        this.Pro_ID=Pro_ID;
        this.ProName=ProName;
        this.ProPrice=ProPrice;
        this.ProQuantity=ProQuantity;
    }


    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public int getPro_ID() {
        return Pro_ID;
    }

    public void setPro_ID(int pro_ID) {
        Pro_ID = pro_ID;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public String getProPrice() {
        return ProPrice;
    }

    public void setProPrice(String proPrice) {
        ProPrice = proPrice;
    }

    public String getProQuantity() {
        return ProQuantity;
    }

    public void setProQuantity(String proQuantity) {
        ProQuantity = proQuantity;
    }

    public int getPro_CatID() {
        return Pro_CatID;
    }

    public void setPro_CatID(int pro_CatID) {
        Pro_CatID = pro_CatID;
    }
}
