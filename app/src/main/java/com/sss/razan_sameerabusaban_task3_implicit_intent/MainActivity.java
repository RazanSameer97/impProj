package com.sss.razan_sameerabusaban_task3_implicit_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.BitmapCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView main_image;
    Button but_takeph, but_gallary,but_nextscre;

    static final int TAKE_IMAGE_ACTIVITY =101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_image = findViewById(R.id.main_image);
        but_takeph = findViewById(R.id.but_takeph);
        but_gallary = findViewById(R.id.but_gallary);
        but_nextscre = findViewById(R.id.but_nextscre);

        but_takeph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent but_takeph = new Intent();
                but_takeph.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(but_takeph, TAKE_IMAGE_ACTIVITY);
            }
        });


        but_gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent but_gallary = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(but_gallary,TAKE_IMAGE_ACTIVITY);
            }
        });



        but_nextscre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getBaseContext(), Screen2.class);
                startActivity(next);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_IMAGE_ACTIVITY && resultCode == RESULT_OK ) {

            main_image.setImageBitmap((Bitmap) data.getExtras().get("data"));
            Uri uri = data.getData();
            main_image.setImageURI(uri);

        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getBaseContext(), "THE USER CANCELLED", Toast.LENGTH_LONG).show();
        }

    }
    }

