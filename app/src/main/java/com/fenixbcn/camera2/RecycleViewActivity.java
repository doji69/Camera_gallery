package com.fenixbcn.camera2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;

public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView rvImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        File sourceDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/image gallery");

        rvImages = (RecyclerView) findViewById(R.id.rvImages);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        rvImages.setLayoutManager(layoutManager);

        RecyclerView.Adapter imageAdapter = new ImageGalleryAdapter(sourceDirectory);
        rvImages.setAdapter(imageAdapter);

    }
}
