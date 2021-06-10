package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import model.Categories;
import java.util.List;
import com.example.ecommerceproject.R;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductViewHolder> {

    Context context;
    List<Categories> productCategoryList;

    public ProductCategoryAdapter(Context context, List<Categories> productCategoryList) {
        this.context = context;
        this.productCategoryList = productCategoryList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_row_item, parent, false);
        // lets create a recyclerview row item layout file
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.catagoryName.setText(productCategoryList.get(position).getCategoryName());

    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
    }


    public static final class ProductViewHolder extends RecyclerView.ViewHolder{


        TextView catagoryName;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryName = itemView.findViewById(R.id.cat_name);

        }
    }

}
