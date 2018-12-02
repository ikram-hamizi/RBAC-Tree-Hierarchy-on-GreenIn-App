package ah.jocelyne.greenin;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VideosTab extends Fragment{

    private ListView listView;
    private VideoAdapter videoAdapter;
    private ArrayList<Video> videos;

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.video_tab, container, false);

        listView = view.findViewById(R.id.my_list_view);
        videos = new ArrayList<Video>();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("DIY").child("VIDEOS");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot video : dataSnapshot.getChildren()) {
                    String title = video.child("Title").getValue(String.class);
                    String img_url = video.child("Image").getValue(String.class);
                    String url = video.child("URL").getValue(String.class);

                    Video vid = new Video(title, img_url, url);
                    videos.add(vid);
                }
                videoAdapter = new VideoAdapter(getActivity(), videos);
                listView.setAdapter(videoAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String link = videos.get(i).getVid_url();
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }
}
