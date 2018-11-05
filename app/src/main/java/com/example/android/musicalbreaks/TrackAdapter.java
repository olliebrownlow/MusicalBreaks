package com.example.android.musicalbreaks;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TrackAdapter extends ArrayAdapter<Track> {

    public TrackAdapter(Activity context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.track_list_view, parent, false);
        }

        // Get the {@link Track} object located at this position in the list
        Track currentTrack = getItem(position);

        // Find the TextView in the track_list_view.xml layout with the ID list_item_track_name
        TextView trackNameTextView = listItemView.findViewById(R.id.list_item_track_name);
        // Get the track name from the current Track object and
        // set this text on the track name TextView
        trackNameTextView.setText(currentTrack.getTrackName());

        // Find the TextView in the track_list_view.xml layout with the ID list_item_artist_name
        TextView artistNameTextView = listItemView.findViewById(R.id.list_item_artist_name);
        // Get the artist name from the current Track object and
        // set this text on the artistNameTextView
        artistNameTextView.setText(currentTrack.getArtistName());

        // Find the ImageView in the track_list_view.xml layout with the ID list_item_album_art
        ImageView albumArtImageView = listItemView.findViewById(R.id.list_item_album_art);
        // Get the album art from the current Track object and
        // set this image to albumArtImageView
        albumArtImageView.setImageResource(currentTrack.getAlbumArtResourceId());

        //Color each list view background item alternately
        if (position % 2 == 1) {
            listItemView.setBackgroundColor(Color.parseColor("#424242"));
        } else {
            listItemView.setBackgroundColor(Color.parseColor("#616161"));
        }

        // Return the whole list item layout (containing 2 TextViews and 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}