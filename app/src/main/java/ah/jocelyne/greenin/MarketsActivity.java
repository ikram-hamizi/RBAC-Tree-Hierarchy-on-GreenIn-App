package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MarketsActivity extends AppCompatActivity {

    private ListView listView;
    private MarketAdapter marketAdapter;
    private ArrayList<Market> markets;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        listView = findViewById(R.id.my_list_view);
        markets = new ArrayList<Market>();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("MARKETS");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot market : dataSnapshot.getChildren()) {
                    String address = market.child("Address").getValue(String.class);
                    String description = market.child("Description").getValue(String.class);
                    String img_url = market.child("Image").getValue(String.class);
                    String location_url = market.child("LocationURL").getValue(String.class);
                    String name = market.child("Name").getValue(String.class);

                    Market m = new Market(address, description, img_url, location_url, name);
                    markets.add(m);
                }
                marketAdapter = new MarketAdapter(getApplicationContext(), markets);
                listView.setAdapter(marketAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String address2 = markets.get(i).getAddress();
                        String description2 = markets.get(i).getDescription();
                        String img_url2 = markets.get(i).getImg_url();
                        String location_url2 = markets.get(i).getLocation_url();
                        String name2 = markets.get(i).getName();

                        Intent intent = new Intent(getApplicationContext(), MarketDetail.class);
                        intent.putExtra("address", address2);
                        intent.putExtra("description", description2);
                        intent.putExtra("img_url", img_url2);
                        intent.putExtra("location_url", location_url2);
                        intent.putExtra("name", name2);
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
