package ah.jocelyne.greenin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ah.jocelyne.greenin.login.LoginActivity;
import ah.jocelyne.greenin.profile.SessionManager;

public class Welcome extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;

    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        session = new SessionManager(getApplicationContext());

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Welcome.this, session.isLoggedIn() ? MainActivity.class : LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
