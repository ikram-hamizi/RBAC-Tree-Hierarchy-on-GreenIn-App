package ah.jocelyne.greenin;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class EventDetail extends AppCompatActivity {

    ImageView imageView;
    TextView date_tv;
    TextView day_tv;
    TextView name_tv;
    TextView location_tv;
    TextView time_tv;

    TextView description_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        imageView = findViewById(R.id.imageView);

        date_tv = findViewById(R.id.date);
        day_tv = findViewById(R.id.day);
        name_tv = findViewById(R.id.name);
        location_tv = findViewById(R.id.location);
        time_tv = findViewById(R.id.time);

        description_tv = findViewById(R.id.description);

        Intent i = getIntent(); //bug was here when it was new Intent

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(getApplicationContext()).load(i.getStringExtra("img_url")).into(imageView);

        date_tv.setText(i.getStringExtra("date"));
        day_tv.setText(i.getStringExtra("day"));
        name_tv.setText(i.getStringExtra("name"));
        location_tv.setText(i.getStringExtra("location"));
        time_tv.setText(i.getStringExtra("time"));
        description_tv.setText(i.getStringExtra("description"));
    }
}