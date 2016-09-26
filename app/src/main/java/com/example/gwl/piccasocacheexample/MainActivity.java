package com.example.gwl.piccasocacheexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private ImageView imageView_default ;
    private Button button_cache, button_no_cache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
    imageView_default   = (ImageView) findViewById(R.id.mainactivity_default_iv);
        button_cache  = (Button) findViewById(R.id.mainactivity_cache_btn);
        button_no_cache = (Button) findViewById(R.id.mainactivity_no_cache_btn);
        button_cache.setOnClickListener(this);
        button_no_cache.setOnClickListener(this);
        using_cache();

    }

    private void using_cache() {
        Picasso.with(this)
                .load("http://i.imgur.com/DvpvklR.png").placeholder(R.mipmap.ic_launcher)

                .into(imageView_default);
    }

    @Override
    public void onClick(View v) {

   using_offline();
    }

    private void using_offline() {
        Picasso.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView_default);
    }
}
