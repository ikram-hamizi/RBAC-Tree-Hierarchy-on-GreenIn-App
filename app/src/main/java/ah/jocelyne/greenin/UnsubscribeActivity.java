package ah.jocelyne.greenin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UnsubscribeActivity extends AppCompatActivity {

    EditText email;
    Button button;

    String email_str;
    boolean user_exists;
    int round;

    DatabaseReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unsubscribe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        email = findViewById(R.id.email);
        button = findViewById(R.id.unsubscribe_button);

        usersRef = FirebaseDatabase.getInstance().getReference().child("SUBSCRIBED_USERS");

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                round = 0;

                email_str = email.getText().toString();
                if(email_str.equals("")) {
                    email.setError("Required field");
                }
                else {
                    usersRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            user_exists = false;
                            round++;

                            for(DataSnapshot user : dataSnapshot.getChildren()) {
                                if(email_str.equalsIgnoreCase(user.child("email").getValue(String.class))) {
                                    user_exists = true;
                                    user.getRef().setValue(null);
                                    Toast.makeText(getApplicationContext(), "You have been unsubscribed.", Toast.LENGTH_LONG).show();
                                    email.setText("");
                                }
                            }

                            if(user_exists == false && round < 2) {
                                Toast.makeText(getApplicationContext(), "You are not already subscribed.", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
}
