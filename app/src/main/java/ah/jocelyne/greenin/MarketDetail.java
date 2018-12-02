package ah.jocelyne.greenin;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MarketDetail extends AppCompatActivity {

    String address;
    String description;
    String img_url;
    String location_url;
    String name;

    ImageView imageView;
    TextView name_tv;
    TextView address_tv;
    TextView description_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);
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
        address = i.getStringExtra("address");
        description = i.getStringExtra("description");
        img_url = i.getStringExtra("img_url");
        location_url = i.getStringExtra("location_url");
        name = i.getStringExtra("name");

        imageView = findViewById(R.id.imageView);
        name_tv = findViewById(R.id.name);
        address_tv = findViewById(R.id.address);
        description_tv = findViewById(R.id.description);

        Glide.with(this).load(img_url).into(imageView);
        name_tv.setText(name);

        if(!address.equalsIgnoreCase("Find a store")) {
            address_tv.setText(address);
            address_tv.setTextColor(getResources().getColor(R.color.black));
        }

        description_tv.setText(description);
    }

    public void onClick(View view) {
        // Build the intent
        Uri location = Uri.parse("geo:0,0?q=" + Uri.encode(name + ", Lebanon"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }
}
