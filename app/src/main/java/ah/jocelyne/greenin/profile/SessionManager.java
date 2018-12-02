package ah.jocelyne.greenin.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import ah.jocelyne.greenin.login.LoginActivity;
import ah.jocelyne.greenin.signup.RegisteredUser;

public class SessionManager {
  SharedPreferences pref;

  SharedPreferences.Editor editor;

  Context context;

  // Shared pref mode
  int PRIVATE_MODE = 0;

  // Shared pref file name
  private static final String PREF_NAME = "SessionManager";

  // All Shared Preferences Keys
  private static final String IS_LOGGED_IN = "IsLoggedIn";

  // make variable public to access from outside
  public static final String KEY_FNAME = "fname";
  public static final String KEY_LNAME = "lname";
  public static final String KEY_EMAIL = "email";
  public static final String KEY_HASHED_PASSWORD = "hashedPassword";
  public static final String KEY_ROLE = "role";

  private RegisteredUser user;

  // Constructor
  public SessionManager(Context context){
    this.context = context;
    pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    editor = pref.edit();
  }

  /**
   * Create login session
   * */
  public void createLoginSession(String fname, String lname, String email, String hashedPassword, String role){

    // store login value as TRUE
    editor.putBoolean(IS_LOGGED_IN, true);

    // store user info in pref
    editor.putString(KEY_FNAME, fname);
    editor.putString(KEY_LNAME, lname);
    editor.putString(KEY_EMAIL, email);
    editor.putString(KEY_HASHED_PASSWORD, hashedPassword);
    editor.putString(KEY_ROLE, role);

    // commit changes
    editor.commit();
  }

  /**
   * Create login session
   * */
  public void createLoginSession(RegisteredUser registeredUser){
    user = registeredUser;

    // store login value as TRUE
    editor.putBoolean(IS_LOGGED_IN, true);

    // store user info in pref
    editor.putString(KEY_FNAME, user.getFirstName());
    editor.putString(KEY_LNAME, user.getLastName());
    editor.putString(KEY_EMAIL, user.getEmail());
    editor.putString(KEY_HASHED_PASSWORD, user.getHashedPassword());
    editor.putString(KEY_ROLE, user.getRole());

    // commit changes
    editor.commit();
  }

  /**
   * Check login method will check user login status
   * If false it will redirect user to login page
   * Else won't do anything
   * */
  public void checkLogin(){

    // Check login status
    if (!this.isLoggedIn()) {

      // user is not logged in redirect him to Login Activity
      Intent i = new Intent(context, LoginActivity.class);

      // Closing all the Activities
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

      // Add new Flag to start new Activity
      i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

      // Staring Login Activity
      context.startActivity(i);
    }

  }

  /**
   * Get stored session data
   * */
  public HashMap<String, String> getUserDetails(){
    HashMap<String, String> user = new HashMap<String, String>();

    user.put(KEY_FNAME, pref.getString(KEY_FNAME, null));
    user.put(KEY_LNAME, pref.getString(KEY_LNAME, null));
    user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
    user.put(KEY_HASHED_PASSWORD, pref.getString(KEY_HASHED_PASSWORD, null));
    user.put(KEY_ROLE, pref.getString(KEY_ROLE, null));

    // return user
    return user;
  }

  //my alternative
  public RegisteredUser getUser() {
    //create user object
    String fname = pref.getString(KEY_FNAME, null);
    user = new RegisteredUser(pref.getString(KEY_FNAME, null),pref.getString(KEY_LNAME, null),
        pref.getString(KEY_EMAIL, null), pref.getString(KEY_HASHED_PASSWORD, null), pref.getString(KEY_ROLE, null));
    return user;
  }

  /**
   * Clear session details
   * */
  public void logoutUser() {
    
    // Clearing all data from Shared Preferences
    editor.clear().commit();
    //editor.commit();

    // After logout redirect user to Login Activity
    Intent i = new Intent(context, LoginActivity.class);

    // Closing all the Activities
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    // Add new Flag to start new Activity
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    // Staring Login Activity
    context.startActivity(i);
  }

  /**
   * Quick check for login
   * **/
  // Get Login State
  public boolean isLoggedIn(){
    return pref.getBoolean(IS_LOGGED_IN, false);
  }

}
