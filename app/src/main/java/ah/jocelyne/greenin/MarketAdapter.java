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

public class MarketAdapter extends BaseAdapter {

    Context context;
    private ArrayList<Market> markets;

    public MarketAdapter(Context context, ArrayList<Market> markets) {
        this.context = context;
        this.markets = markets;
    }

    @Override
    public int getCount() {
        return markets.size();
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
        view = layoutInflater.inflate(R.layout.market_row, null);

        TextView tv = view.findViewById(R.id.market_title);
        tv.setText(markets.get(i).getName());

        return view;
    }
}
