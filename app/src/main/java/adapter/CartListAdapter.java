package adapter;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceproject.Ecommercehelper;
import com.example.ecommerceproject.Productdetails;
import com.example.ecommerceproject.R;
import com.example.ecommerceproject.shopping;

import java.util.List;
import model.shopping_cart;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder>
{
        private Activity context;
         List<shopping_cart> ShoppingCart;
         int sum=0;
         String User_Name;
    String QYtafteredit;

        public CartListAdapter(Activity context, List<shopping_cart> shopping_cart,String username)
        {
            super();
            this.context = context;
            this.ShoppingCart=shopping_cart;
            this.User_Name=username;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.singleitemlayout, parent, false);
            return new ViewHolder(itemView);
        }
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.itemname.setText(ShoppingCart.get(position).getProductname());
            holder.item_quantity.setText(ShoppingCart.get(position).getProduct_QYT());
            holder.itemprice.setText(ShoppingCart.get(position).getProduct_price());

            //holder.itemtotal.setText(Integer.toString(Integer.valueOf(holder.item_quantity.getText().toString())*Integer.valueOf(holder.itemprice.getText().toString())));
        }
        public int getItemCount() {
            //Log.d("Size List:",String.valueOf(callListResponses.size()));
            if(ShoppingCart!=null){
                return ShoppingCart.size();
            }
            return 0;
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView itemprice,itemname,item_quantity,itemtotal;
            ImageView cart_minus_img, cart_plus_img,img_deleteitem;
            public ViewHolder(View itemView) {
                super(itemView);
                cart_minus_img=(ImageView) itemView.findViewById(R.id.minus_shopping);
                cart_plus_img=(ImageView) itemView.findViewById(R.id.plus_shopping);
                img_deleteitem=(ImageView) itemView.findViewById(R.id.delete_cart);
                itemname=(TextView) itemView.findViewById(R.id.prod_cart_name);
                itemprice=(TextView) itemView.findViewById(R.id.item_price_cart);
                item_quantity=(TextView) itemView.findViewById(R.id.item_QYT);
                itemtotal=(TextView) itemView.findViewById(R.id.item_total);

                cart_minus_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int quantity=Integer.parseInt(item_quantity.getText().toString());
                        if(quantity-->0){
                            item_quantity.setText(Integer.toString(quantity--));
                        }
                        QYtafteredit=Integer.toString(quantity);

                    }
                });
                cart_plus_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //int Quantity2=Integer.parseInt(item_quantity.getText().toString());
                        int quantity=Integer.parseInt(item_quantity.getText().toString());
                        //if(quantity++<Quantity2){
                            item_quantity.setText(Integer.toString(quantity++));
                        //}
                        QYtafteredit=Integer.toString(quantity);

                    }
                });
                img_deleteitem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        notifyItemRemoved(getAdapterPosition());
                        notifyDataSetChanged();
                        Ecommercehelper Helper=new Ecommercehelper(context);
                        Helper.updateactive(User_Name,itemname.getText().toString());
                        notifyItemRemoved(getAdapterPosition());
                        Intent i=new Intent(context, shopping.class);
                        i.putExtra("User_Name",User_Name);
                        context.startActivity(i);

                    }
                });
            }
        }
}
