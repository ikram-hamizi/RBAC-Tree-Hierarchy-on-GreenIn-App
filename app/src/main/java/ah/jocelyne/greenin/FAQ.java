package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class FAQ extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private QuestionAdapter adapter;
    private ArrayList<String> questions;
    private HashMap<String, ArrayList<String>> answers; //maps each question to an answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        expandableListView = findViewById(R.id.expListView);
        expandableListView.setIndicatorBounds(expandableListView.getRight() - 400, expandableListView.getWidth());
        prepListData();

        adapter = new QuestionAdapter(FAQ.this, questions, answers);
        expandableListView.setAdapter(adapter);
    }

    public void prepListData() {
        questions = new ArrayList<String>();
        answers = new HashMap<String, ArrayList<String>>();

        questions.add("What type of supermarket bag is more ecofriendly, paper or plastic?");
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("None of the above.");

        questions.add("How do I know which green items are the best for the planet and my family?");
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("If it says 'earth-safe,' 'cruelty-free,' or 'natural,'" +
                " you should be skeptical until you read the ingredients." +
                " Products that contain ingredients with recognizable names" +
                " (instead of hard-to-pronounce chemical compounds) are probably better for the earth than their counterparts.");

        questions.add("Appliances that are turned off don't use any electricity. True/False?");
        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("False: Many appliances continue to use energy for features like" +
                " clocks and remote control sensors even when they're turned off.");

        questions.add("Hybrid cars are slower and less safe than conventional cars. True/False?");
        ArrayList<String> a4 = new ArrayList<String>();
        a4.add("False: Hybrid cars perform on par with or better than conventional cars in drivability and safety testing.");

        questions.add("Approximately how much global electricity output is produced from renewable sources?");
        ArrayList<String> a5 = new ArrayList<String>();
        a5.add("Only about 10 percent of global energy comes from renewables." +
                " The remaining 92 percent comes from non-renewable sources like oil, coal, and natural gas.");

        questions.add("I know that the number on the bottom of plastic containers indicates whether they can be recycled, but what do the individual numbers mean?");
        ArrayList<String> a6 = new ArrayList<String>();
        a6.add("There are seven code numbers inside the three-chasing-arrow triangle symbol generally" +
                " found at the bottom of a container. Codes 1 through 6 describe the predominant type of" +
                " resin used to manufacture the product, while code 7 is a catchall for other plastics. " +
                "Plastics labeled 1 (soda and water bottles, oven-ready trays) and 2 (detergent bottles, milk bottles)" +
                " are the most widely recyclable at recycling centers and curbside pickups (but remove the bottle tops, " +
                "since they're made of a different type of plastic). The higher numbers are reserved for denser plastics, " +
                "like prescription bottles and yogurt cups.");

        answers.put(questions.get(0), a1);
        answers.put(questions.get(1), a2);
        answers.put(questions.get(2), a3);
        answers.put(questions.get(3), a4);
        answers.put(questions.get(4), a5);
        answers.put(questions.get(5), a6);
    }
}