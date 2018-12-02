package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CategoryItemDetail extends AppCompatActivity {

    private String chosen_category;
    private String chosen_category_item;

    String img_url;
    private DatabaseReference mDatabase;

    ImageView imageView;
    TextView textView;
    TextView web_tv;

    String name;
    String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent i = getIntent();
        chosen_category = i.getStringExtra("chosen_category");
        chosen_category_item = i.getStringExtra("chosen_category_item");
        toolbar.setTitle(chosen_category_item);
        this.setTitle(chosen_category_item);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.description);
        web_tv = findViewById(R.id.website_textview);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("SOLUTION")
                .child(chosen_category).child(chosen_category_item);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot category_item) {
                String img_url = category_item.child("Image").getValue(String.class);
                Glide.with(getApplicationContext()).load(img_url).into(imageView);

                String desc = category_item.child("About").getValue(String.class);
                textView.setText(desc);

                name = category_item.child("Name").getValue(String.class);
                website = category_item.child("Website").getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, CategWebDetail.class);
        intent.putExtra("article_title", name);
        intent.putExtra("url", website);
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {
//        Intent i = new Intent(this, CategoryActivity.class);
//        i.putExtra("chosen_category", chosen_category);
//        startActivity(i);
//    }
}
