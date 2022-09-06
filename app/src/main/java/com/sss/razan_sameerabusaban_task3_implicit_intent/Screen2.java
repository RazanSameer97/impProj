package com.sss.razan_sameerabusaban_task3_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.EmbossMaskFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {
    Button but_call, but_facebook, but_website, but_email, but_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        but_call = findViewById(R.id.but_call);
        but_facebook = findViewById(R.id.but_facebook);
        but_website = findViewById(R.id.but_website);
        but_email = findViewById(R.id.but_email);
        but_cancel = findViewById(R.id.but_cancel);

        but_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                Uri my_data = Uri.parse("tel: 0599688870 ");
                call.setData(my_data);
                startActivity(call);
            }
        });

        but_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(Intent.ACTION_VIEW);
                Uri facebook = Uri.parse("https://www.facebook.com/RazanSameerAbuShaban");
                f.setData(facebook);
                startActivity(f);
            }
        });
        but_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Intent.ACTION_VIEW);
                Uri UCAS = Uri.parse("https://newucas.ucas.edu.ps/");
                web.setData(UCAS);
                startActivity(web);
            }
        });
        but_email.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, "rabushaban3@smail.ucas.edu.ps");
                email.putExtra(Intent.EXTRA_EMAIL,"MESSAGE TITLE");
                startActivity(email);
            }
        });

        but_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(getBaseContext(),"THANKS FOR TRYING", Toast.LENGTH_LONG).show();
            }
        });
    }
}
