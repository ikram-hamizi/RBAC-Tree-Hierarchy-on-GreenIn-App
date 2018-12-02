package ah.jocelyne.greenin;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import java.util.List;

public class CategWebDetail extends AppCompatActivity {

    ProgressBar progress_bar;
    WebView myWebView;

    String article_title;
    String url;
    String website_display;

    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categ_web_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        article_title = intent.getStringExtra("article_title");
        url = intent.getStringExtra("url");

        int start_index = 0;
        int end_index = url.length();
        for(int i = 0; i < url.length(); i++) {
            if(url.charAt(i) == 'w' && url.charAt(i + 1) == '.') {
                start_index = i + 2;
                break;
            }
        }
        website_display = url.substring(start_index, end_index);
        toolbar.setSubtitle(website_display);

        this.setTitle(article_title);

        progress_bar = findViewById(R.id.progressBar);
        myWebView = (WebView) findViewById(R.id.webView);
        renderWebPage(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, url);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "SHARE"));
                return true;
            case R.id.browser:
                // Build the intent
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verify it resolves
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(myIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(myIntent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Custom method to render a web page
    protected void renderWebPage(String urlToRender){
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                // Do something on page loading started
                // Visible the progressbar
                progress_bar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url){
                // Do something when page loading finished
                progress_bar.setVisibility(View.GONE);
                myWebView.setVisibility(View.VISIBLE);
            }
        });

        /*
            WebView
                A View that displays web pages. This class is the basis upon which you can roll your
                own web browser or simply display some online content within your Activity. It uses
                the WebKit rendering engine to display web pages and includes methods to navigate
                forward and backward through a history, zoom in and out, perform text searches and more.

            WebChromeClient
                 WebChromeClient is called when something that might impact a browser UI happens,
                 for instance, progress updates and JavaScript alerts are sent here.
        */
        myWebView.setWebChromeClient(new WebChromeClient(){
            /*
                public void onProgressChanged (WebView view, int newProgress)
                    Tell the host application the current progress of loading a page.

                Parameters
                    view : The WebView that initiated the callback.
                    newProgress : Current page loading progress, represented by an integer
                        between 0 and 100.
            */
            public void onProgressChanged(WebView view, int newProgress){
                // Update the progress bar with page loading progress
                progress_bar.setProgress(newProgress);
                if(newProgress == 100){
                    // Hide the progressbar
                    progress_bar.setVisibility(View.GONE);
                }
            }
        });

        // Enable the javascript
        myWebView.getSettings().setJavaScriptEnabled(true);
        // Render the web page
        myWebView.loadUrl(urlToRender);
    }
}
