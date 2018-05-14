package com.fenixbcn.camera2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by javiercabregarcia on 14/5/18.
 */

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.ViewHolder> {

    private File imagesFiles;

    public ImageGalleryAdapter(File folderFile ) {

        imagesFiles = folderFile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        File imageFile = imagesFiles.listFiles() [position];
        Bitmap imageBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        holder.getImageView().setImageBitmap(imageBitmap);

    }

    @Override
    public int getItemCount() {
        return imagesFiles.listFiles().length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.ivSingleImage);

        }

        public ImageView getImageView () {

            return imageView;
        }


    }
}
