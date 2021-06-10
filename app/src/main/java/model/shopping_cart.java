package model;

public class shopping_cart {
    public String Cartid;
    public String username;
    public String product_price;
    public String productname;
    public String product_QYT;
    public String active;



    public shopping_cart(String username, String productname, String product_QYT, String active,String product_price) {

        this.username = username;
        this.productname = productname;
        this.product_QYT = product_QYT;
        this.active = active;
        this.product_price=product_price;
    }

    public String getCartid() {
        return Cartid;
    }

    public void setCartid(String cartid) {
        Cartid = cartid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct_price() {
        return product_price;
    }


    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProduct_QYT() {
        return product_QYT;
    }

    public void setProduct_QYT(String product_QYT) {
        this.product_QYT = product_QYT;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}

