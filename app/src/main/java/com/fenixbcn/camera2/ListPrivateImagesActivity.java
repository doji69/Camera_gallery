package com.fenixbcn.camera2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListPrivateImagesActivity extends AppCompatActivity {

    ListView lvItems;
    private List<String> imageList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_private_images);

        lvItems = (ListView) findViewById(R.id.lwItems);


        File sourceDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/image gallery");
        File[] images = sourceDirectory.listFiles();

        System.out.println("el directorio es " + sourceDirectory);

        for (File image : images) {
            imageList.add(image.getName());
        }


        ArrayAdapter<String> aaItems = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,imageList);

        lvItems.setAdapter(aaItems);
    }






}
