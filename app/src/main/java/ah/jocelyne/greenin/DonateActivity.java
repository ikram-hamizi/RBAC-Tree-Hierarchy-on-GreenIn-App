package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class DonateActivity extends AppCompatActivity {

    Spinner countries_spinner;
    Spinner phone_type_spinner;

    EditText amount;
    EditText card_no;
    EditText expires;
    EditText security_code;
    EditText fname;
    EditText lname;
    EditText address;
    EditText optional;
    EditText city;
    EditText state;
    EditText phone_no;
    EditText email;

    Button donate_button;

    ArrayList<String> listOfPattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        listOfPattern=new ArrayList<String>();

        String ptVisa = "^4[0-9]{6,}$";
        listOfPattern.add(ptVisa);
        String ptMasterCard = "^5[1-5][0-9]{5,}$";
        listOfPattern.add(ptMasterCard);
        String ptAmeExp = "^3[47][0-9]{5,}$";
        listOfPattern.add(ptAmeExp);
        String ptDinClb = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$";
        listOfPattern.add(ptDinClb);
        String ptDiscover = "^6(?:011|5[0-9]{2})[0-9]{3,}$";
        listOfPattern.add(ptDiscover);
        String ptJcb = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$";
        listOfPattern.add(ptJcb);

        amount = findViewById(R.id.amount);
        card_no = findViewById(R.id.card_number);
        expires = findViewById(R.id.expires);
        security_code = findViewById(R.id.security_code);
        fname = findViewById(R.id.first_name);
        lname = findViewById(R.id.last_name);
        address = findViewById(R.id.street_address);
        optional = findViewById(R.id.optional);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        phone_no = findViewById(R.id.phone_no);
        email = findViewById(R.id.email);

        countries_spinner = findViewById(R.id.countries_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner (Binding step)
        countries_spinner.setAdapter(adapter);
        String country_chosen = countries_spinner.getSelectedItem().toString();


        phone_type_spinner = findViewById(R.id.phone_type_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.phone_type_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner (Binding step)
        phone_type_spinner.setAdapter(adapter2);
        String phone_type_chosen = phone_type_spinner.getSelectedItem().toString();

        donate_button = findViewById(R.id.donate_now);
        donate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean error_found = false;

                if(amount.getText().toString().equals("")) {
                    amount.setError("Required field");
                    error_found = true;
                }

                if(card_no.getText().toString().equals("")) {
                    card_no.setError("Required field");
                    error_found = true;
                }
                else if(!card_no.getText().toString().equals("")) {
                    String ccNum = card_no.getText().toString();
                    for(String p:listOfPattern){
                        if(ccNum.matches(p)){
                            card_no.setError("Invalid credit card number");
                            error_found = true;
                            break;
                        }
                    }
                }

                if(expires.getText().toString().equals("")) {
                    expires.setError("Required field");
                    error_found = true;
                }

                if(security_code.getText().toString().equals("")) {
                    security_code.setError("Required field");
                    error_found = true;
                }

                if(fname.getText().toString().equals("")) {
                    fname.setError("Required field");
                    error_found = true;
                }

                if(lname.getText().toString().equals("")) {
                    lname.setError("Required field");
                    error_found = true;
                }

                if(address.getText().toString().equals("")) {
                    address.setError("Required field");
                    error_found = true;
                }
                else if(city.getText().toString().equals("")) {
                    city.setError("Required field");
                    error_found = true;
                }

                if(state.getText().toString().equals("")) {
                    state.setError("Required field");
                    error_found = true;
                }

                if(phone_no.getText().toString().equals("")) {
                    phone_no.setError("Required field");
                    error_found = true;
                }

                if(email.getText().toString().equals("")) {
                    email.setError("Required field");
                    error_found = true;
                }

                if(!error_found) {
                    Intent i = new Intent(getApplicationContext(), PostDonationActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}