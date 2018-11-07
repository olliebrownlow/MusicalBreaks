package com.example.android.musicalbreaks;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Activity context, ArrayList<Artist> artists) { super(context, 0, artists); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_of_artists_view, parent, false);
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Find the TextView in the list_of_artists_viewview.xml layout with the ID list_item_artist_name
        TextView artistNameTextView = listItemView.findViewById(R.id.list_item_artist_name);
        // Get the artist name from the current Artist object and
        // set this text on the artistNameTextView
        artistNameTextView.setText(currentArtist.getArtistName());

        //Color each list view background item alternately
        if (position % 2 == 1) {
            listItemView.setBackgroundColor(Color.parseColor("#424242"));
        } else {
            listItemView.setBackgroundColor(Color.parseColor("#616161"));
        }

        // Return the whole list item layout (containing 1 TextView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
