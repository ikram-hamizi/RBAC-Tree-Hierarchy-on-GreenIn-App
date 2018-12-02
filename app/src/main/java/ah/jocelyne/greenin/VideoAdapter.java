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

public class VideoAdapter extends BaseAdapter {

    Context context;
    ArrayList<Video> videos;

    public VideoAdapter(Context c, ArrayList<Video> list) {
        context = c;
        videos = list;
    }

    @Override
    public int getCount() {
        return videos.size();
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
        view = layoutInflater.inflate(R.layout.video_row, null);

        ImageView imageView = view.findViewById(R.id.video_pic);
        String img_url = videos.get(i).getImg_url();
        Glide.with(context).load(img_url).into(imageView);

        TextView tv = view.findViewById(R.id.vid_title);
        tv.setText(videos.get(i).getTitle());

        return view;
    }
}
