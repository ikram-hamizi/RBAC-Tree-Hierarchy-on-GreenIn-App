package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SolutionsActivity extends AppCompatActivity implements View.OnClickListener {
    CardView renewable_energy_but;
    CardView waste_but;
    CardView climate_but;
    CardView nature_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        renewable_energy_but = findViewById(R.id.renewable_energy_but);
        renewable_energy_but.setOnClickListener(this);

        waste_but = findViewById(R.id.waste_but);
        waste_but.setOnClickListener(this);

        climate_but = findViewById(R.id.climate_but);
        climate_but.setOnClickListener(this);

        nature_but = findViewById(R.id.nature_but);
        nature_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = getIntent();
        String chosen_category = "";

        switch (view.getId()) {
            case R.id.renewable_energy_but:
                chosen_category = "Renewable energy";
                break;
            case R.id.waste_but:
                chosen_category = "Waste management";
                break;
            case R.id.climate_but:
                chosen_category = "Climate change";
                break;
            case R.id.nature_but:
                chosen_category = "Nature conservation";
                break;
        }
        i = new Intent(this, CategoryActivity.class);
        i.putExtra("chosen_category", chosen_category);
        startActivity(i);
    }
}
