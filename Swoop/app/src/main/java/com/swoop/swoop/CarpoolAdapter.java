package com.swoop.swoop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapping.Carpool;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by naelin on 11/27/16.
 */

public class CarpoolAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Carpool> mDataSource;

    public CarpoolAdapter(Context context, ArrayList<Carpool> items) {
        mContext = context;
        mDataSource = items;
        mInflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = mInflator.inflate(R.layout.list_item_carpool, viewGroup, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(com.swoop.swoop.R.id.carpool_list_title);

// Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(com.swoop.swoop.R.id.carpool_list_subtitle);

// Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(com.swoop.swoop.R.id.carpool_list_detail);

// Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(com.swoop.swoop.R.id.user_photo);

        Carpool carpool = (Carpool) getItem(i);

        titleTextView.setText(carpool.getStartLocation());
        subtitleTextView.setText(carpool.getEndLocation());
        detailTextView.setText(carpool.getTimeStamp());


        /* more info: https://www.raywenderlich.com/124438/android-listview-tutorial */
        Picasso.with(mContext).load("https://s-media-cache-ak0.pinimg.com/564x/fd/0c/55/fd0c559856ca991e9e28937dc802f0b0.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }
}