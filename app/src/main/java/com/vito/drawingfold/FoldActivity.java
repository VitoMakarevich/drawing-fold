package com.vito.drawingfold;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class FoldActivity extends AppCompatActivity {

    public static final String ARG_IMAGE_NAME = "com.vito.drawingfold.imageName";
    public static final String ARG_IMAGE_TYPE = "com.vito.drawingfold.imageType";


    private ImageView mImageView;

    private String mImageName;
    private int mImageType;
    private String mImageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fold);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mImageView = findViewById(R.id.foldImageView);

        Intent intent = getIntent();
        mImageName = intent.getStringExtra(ARG_IMAGE_NAME);
        mImageType = intent.getIntExtra(ARG_IMAGE_TYPE, 1);
        makeImageURL();

        Bitmap bitmap = null;
        try {
            InputStream is = getAssets().open(mImageURL);
            bitmap = BitmapFactory.decodeStream(is);
        }
        catch (IOException exception){
        }
        if(bitmap != null){
            mImageView.setImageBitmap(bitmap);
        }
    }

    private void makeImageURL(){
        if(mImageName == null) {
            mImageURL = "land/A1.png";
            return;
        }
        else{
            switch (mImageType){
                case 1:
                    mImageURL = "land/";
                    break;
                case 2:
                    mImageURL = "port/";
                    break;
            }
            mImageURL += mImageName;
            mImageURL += ".png";
        }
    }
}
