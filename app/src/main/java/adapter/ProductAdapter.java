//package adapter;
package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import model.Products;
import com.example.ecommerceproject.R;
import com.example.ecommerceproject.Productdetails;
import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<Products> productsList;
    String username;

    public ProductAdapter(Context context, List<Products> productsList,String username) {
        this.context = context;
        this.productsList = productsList;
        this.username=username;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.products_row_item, parent, false);
        return new ProductViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {

        holder.prodName.setText(productsList.get(position).getProName());
        holder.prodQty.setText(productsList.get(position).getProQuantity());
        holder.prodPrice.setText(productsList.get(position).getProPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Productdetails.class);
                i.putExtra("product name",productsList.get(position).ProName);
                i.putExtra("product price",productsList.get(position).ProPrice);
                i.putExtra("product Quantity",productsList.get(position).ProQuantity);
                i.putExtra("product_CAT_ID",productsList.get(position).Pro_CatID);
                i.putExtra("User_Name",username);
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount()
    {
        return productsList.size();
    }
    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView prodName, prodQty, prodPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodName = itemView.findViewById(R.id.prod_name);
            prodPrice = itemView.findViewById(R.id.prod_price);
            prodQty = itemView.findViewById(R.id.prod_qty);
        }
    }
}
