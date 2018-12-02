package ah.jocelyne.greenin;

import android.content.Intent;
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

public class ArticlesTab extends Fragment {

    private ListView listView;
    private ArticleAdapter articleAdapter;
    private ArrayList<Article> articles;

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_tab, container, false);

        listView = view.findViewById(R.id.my_list_view);
        articles = new ArrayList<Article>();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("DIY").child("ARTICLES");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot article : dataSnapshot.getChildren()) {
                    String title = article.child("Title").getValue(String.class);
                    String img_url = article.child("Image").getValue(String.class);
                    String url = article.child("URL").getValue(String.class);

                    Article art = new Article(title, img_url, url);
                    articles.add(art);
                }
                articleAdapter = new ArticleAdapter(getActivity(), articles);
                listView.setAdapter(articleAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String link = articles.get(i).getUrl();
                        Intent intent = new Intent(getActivity(), NewsItemDetail.class);
                        intent.putExtra("article_title", articles.get(i).getTitle());
                        intent.putExtra("url", link);
                        startActivity(intent);
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
