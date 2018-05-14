package com.fenixbcn.camera2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

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
        Bitmap finalImageBitmap = rotateImage(imageBitmap, imageFile.getAbsolutePath());
        holder.getImageView().setImageBitmap(finalImageBitmap);

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

    private Bitmap rotateImage (Bitmap bitmap, String imageFullPath) {

        ExifInterface exifInterface = null;

        try {

            exifInterface = new ExifInterface(imageFullPath);
            System.out.println("la orientacion es " + imageFullPath);
        } catch (IOException e) {

            e.printStackTrace();
        }
        int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);
        Matrix matrix = new Matrix();

        System.out.println("la orientacion es " + orientation);

        switch (orientation) {

            case ExifInterface.ORIENTATION_ROTATE_90:
                matrix.setRotate(90);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                matrix.setRotate(180);
                break;
            default:
        }

        Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth(), bitmap.getHeight(), matrix,true);
        return rotatedBitmap;

    }
}
