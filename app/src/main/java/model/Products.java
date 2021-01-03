package model;

public class Products {
    public String Pro_ID;
    public String ProName;
    public String ProPrice;
    public String ProQuantity;
    public int Pro_CatID;
    public String barcode;

    public Products( String Pro_ID, String ProName, String ProPrice, String ProQuantity, int Pro_CatID,String  barcode)
    {
        this.Pro_CatID=Pro_CatID;
        this.Pro_ID=Pro_ID;
        this.ProName=ProName;
        this.ProPrice=ProPrice;
        this.ProQuantity=ProQuantity;
        this.barcode=barcode;
    }
    public Products(String ProName, String ProPrice, String ProQuantity, int Pro_CatID,String  barcode)
    {

        this.Pro_ID=Pro_ID;
        this.ProName=ProName;
        this.ProPrice=ProPrice;
        this.ProQuantity=ProQuantity;
        this.barcode=barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPro_ID() {
        return Pro_ID;
    }

    public void setPro_ID(String pro_ID) {
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
