package ah.jocelyne.greenin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder> {

    private ArrayList<CategoryItem> items;
    private Context context;
    private String category;

    public CategoryItemAdapter(ArrayList<CategoryItem> list, Context c, String categ) {
        items = list;
        context = c;
        category = categ;
    }

    public static class CategoryItemViewHolder extends RecyclerView.ViewHolder {
        public static LinearLayout layout;
        public static ImageView imageView;
        public static TextView textView;

        CategoryItemViewHolder(View view) {
            super(view);
            layout = view.findViewById(R.id.category_item_layout);
            imageView = view.findViewById(R.id.logo_iv);
            textView = view.findViewById(R.id.name);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CategoryItemAdapter.CategoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_row, parent, false);
        CategoryItemViewHolder vh = new CategoryItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemAdapter.CategoryItemViewHolder holder, int position) {
        String img_url = items.get(position).getImg_url();
        final String name = items.get(position).getName();

        Glide.with(context).load(img_url).into(holder.imageView);
        holder.textView.setText(name);

        //handle clicking on items
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, CategoryItemDetail.class);
                i.putExtra("chosen_category", category);
                i.putExtra("chosen_category_item", name);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
