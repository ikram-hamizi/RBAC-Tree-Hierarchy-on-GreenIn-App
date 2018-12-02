package ah.jocelyne.greenin.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import ah.jocelyne.greenin.R;
import ah.jocelyne.greenin.signup.RegisteredUser;

public class ProfileActivity extends AppCompatActivity {

  SessionManager session;
  RegisteredUser user;

  TextView mFirstNameView;
  TextView mLastNameView;
  TextView mEmailView;
  TextView mRoleView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);

    mFirstNameView = findViewById(R.id.first_name);
    mLastNameView = findViewById(R.id.last_name);
    mEmailView = findViewById(R.id.email);
    mRoleView = findViewById(R.id.role);

    //get user from session
    session = new SessionManager(getApplicationContext());
  }

  @Override
  protected void onResume() {
    super.onResume();
    fillProfileInfo();
  }

  private void fillProfileInfo() {
    user = session.getUser();
    mFirstNameView.setText(user.getFirstName());
    mLastNameView.setText(user.getLastName());
    mEmailView.setText(user.getEmail());
    mRoleView.setText(user.getRole());
  }
}
