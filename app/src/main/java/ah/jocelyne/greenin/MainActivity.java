package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView events_but;
    CardView solutions_but;
    CardView news_but;
    CardView diy_but;
    CardView markets_but;
    CardView faq_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        events_but = findViewById(R.id.events_but);
        events_but.setOnClickListener(this);

        solutions_but = findViewById(R.id.solutions_but);
        solutions_but.setOnClickListener(this);

        news_but = findViewById(R.id.news_but);
        news_but.setOnClickListener(this);

        diy_but = findViewById(R.id.diy_but);
        diy_but.setOnClickListener(this);

        markets_but = findViewById(R.id.markets_but);
        markets_but.setOnClickListener(this);

        faq_but = findViewById(R.id.faq_but);
        faq_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = getIntent();
        switch (view.getId()) {
            case R.id.events_but:
                i = new Intent(this, EventsActivity.class);
                break;

            case R.id.solutions_but:
                i = new Intent(this, SolutionsActivity.class);
                break;

            case R.id.news_but:
                i = new Intent(this, NewsfeedActivity.class);
                break;

            case R.id.diy_but:
                i = new Intent(this, DIY_Activity.class);
                break;

            case R.id.markets_but:
                i = new Intent(this, MarketsActivity.class);
                break;

            case R.id.faq_but:
                i = new Intent(this, FAQ.class);
                break;
        }
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = getIntent();

        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.donate:
                i = new Intent(this, DonateActivity.class);
                startActivity(i);
                return true;
            case R.id.about_us:
                i = new Intent(this, AboutUs.class);
                startActivity(i);
                return true;
            case R.id.subscribe:
                i = new Intent(this, SubscribeActivity.class);
                startActivity(i);
                return true;
            case R.id.unsubscribe:
                i = new Intent(this, UnsubscribeActivity.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
