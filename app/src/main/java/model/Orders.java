package model;

public class Orders {
    public String Order_ID;
    public String OrderDate;
    public String User_ID;
    public String Address;

    public Orders( String Order_ID, String OrderDate, String User_ID, String Address){
        this.Address=Address;
        this.Order_ID=Order_ID;
        this.OrderDate=OrderDate;
        this.User_ID=User_ID;


    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String order_ID) {
        Order_ID = order_ID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
