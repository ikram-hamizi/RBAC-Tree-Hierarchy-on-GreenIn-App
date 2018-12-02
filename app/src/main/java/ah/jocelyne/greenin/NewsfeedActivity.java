package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewsfeedActivity extends AppCompatActivity {

    private ListView listView;
    private NewsItemAdapter newsItemAdapter;
    private ArrayList<NewsItem> newsItems;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        listView = findViewById(R.id.news_list_view);
        newsItems = new ArrayList<NewsItem>();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("NEWSFEED");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot news_item : dataSnapshot.getChildren()) {
                    String title = news_item.child("Title").getValue(String.class);
                    String img_url = news_item.child("Image").getValue(String.class);
                    String url = news_item.child("URL").getValue(String.class);

                    NewsItem newsItem = new NewsItem(title, img_url, url);
                    newsItems.add(newsItem);
                }
                newsItemAdapter = new NewsItemAdapter(getApplicationContext(), newsItems);
                listView.setAdapter(newsItemAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String article_title = newsItems.get(i).getTitle();
                        String link = newsItems.get(i).getUrl();
                        Intent intent = new Intent(getApplicationContext(), NewsItemDetail.class); //error could be here
                        intent.putExtra("article_title", article_title);
                        intent.putExtra("url", link);
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
