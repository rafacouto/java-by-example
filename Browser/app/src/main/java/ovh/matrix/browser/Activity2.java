package ovh.matrix.browser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Activity2 extends AppCompatActivity {

    WebView webView1;
    WebView webView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        webView1 = (WebView) findViewById(R.id.webView1);
        webView2 = (WebView) findViewById(R.id.webView2);

        webView1.loadUrl("file:///android_asset/1.jpg");
        webView2.loadUrl("file:///android_asset/data.html");
    }
}
