package com.mengadevelopers.pancard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mengadevelopers.pancard.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    Intent intent;
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent = getIntent();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Resources resources = getResources();

        String[] urls = resources.getStringArray(R.array.urls);

binding.back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
        WebView myWebView = (WebView) findViewById(R.id.intructiontext);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setAllowContentAccess(true);
        myWebView.getSettings().setAllowFileAccess(true);

        int code = intent.getIntExtra("key", 0);
        if (code == 1) {
            web("download");

            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openurl(urls[0]);
                }
            });
        } else if (code == 2) {
            web("track");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openurl(urls[1]);
                }
            });
        } else if (code == 3) {
            web("apply");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openurl(urls[2]);
                }
            });
        } else if (code == 4) {
            web("link");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openurl(urls[3]);
                }
            });
        } else if (code == 5) {
            web("correstion");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openurl(urls[4]);
                }
            });
        }
        binding.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment fragment=new BlankFragment();
                fragment.show(getSupportFragmentManager(),fragment.getTag());
            }
        });

    }
    private void web(String key){
        String file="file:///android_asset/";
        binding.intructiontext.loadUrl(file+key+".html");
    }

    private void openurl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);


    }
}