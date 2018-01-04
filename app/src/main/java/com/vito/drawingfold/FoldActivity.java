package com.vito.drawingfold;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class FoldActivity extends AppCompatActivity {

    public static final String ARG_IMAGE_NAME = "com.vito.drawingfold.imageName";

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fold);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mImageView = findViewById(R.id.foldImageView);

        Intent intent = getIntent();
        String imageName = intent.getStringExtra(ARG_IMAGE_NAME);
        if(imageName == null)
            imageName = "a1.jpg";
        else
            imageName = imageName + ".jpg";

        Bitmap bitmap = null;
        try {
            InputStream is = getAssets().open(imageName);
            bitmap = BitmapFactory.decodeStream(is);
        }
        catch (IOException exception){
        }
        if(bitmap != null){
            mImageView.setImageBitmap(bitmap);
        }
    }
}
