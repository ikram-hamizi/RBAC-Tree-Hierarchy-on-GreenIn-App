package ah.jocelyne.greenin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ArticleDetail extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_detail);

        Intent i = getIntent();
        String url = i.getStringExtra("url");

        myWebView = (WebView) findViewById(R.id.my_webview);
        myWebView.loadUrl(url);
    }
}
