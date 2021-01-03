package model;

public class Order_Details {
    public String OrderDetailes_ID;
    public String Order_ID;
    public String Pro_ID;
    public String Item_Quantity;

    public Order_Details( String OrderDetailes_ID, String Order_ID, String Pro_ID, String Item_Quantity){
        this.Item_Quantity=Item_Quantity;
        this.Order_ID=Order_ID;
        this.OrderDetailes_ID=OrderDetailes_ID;
        this.Pro_ID=Pro_ID;

    }

    public String getOrderDetailes_ID() {
        return OrderDetailes_ID;
    }

    public void setOrderDetailes_ID(String orderDetailes_ID) {
        OrderDetailes_ID = orderDetailes_ID;
    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String order_ID) {
        Order_ID = order_ID;
    }

    public String getPro_ID() {
        return Pro_ID;
    }

    public void setPro_ID(String pro_ID) {
        Pro_ID = pro_ID;
    }

    public String getItem_Quantity() {
        return Item_Quantity;
    }

    public void setItem_Quantity(String item_Quantity) {
        Item_Quantity = item_Quantity;
    }
}
