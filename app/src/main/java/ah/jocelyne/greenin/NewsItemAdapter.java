package ah.jocelyne.greenin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsItemAdapter extends BaseAdapter{

    Context context;
    ArrayList<NewsItem> newsItems;

    public NewsItemAdapter(Context context, ArrayList<NewsItem> newsItems) {
        this.context = context;
        this.newsItems = newsItems;
    }

    @Override
    public int getCount() {
        return newsItems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.newsfeed_row, null);

        ImageView imageView = view.findViewById(R.id.myImageView);
        String img_url = newsItems.get(i).getImg_url();
        Glide.with(context).load(img_url).into(imageView);

        TextView tv = view.findViewById(R.id.myImageViewText);
        tv.setText(newsItems.get(i).getTitle());

        return view;
    }
}
