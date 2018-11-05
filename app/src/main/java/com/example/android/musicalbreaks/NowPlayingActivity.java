package com.example.android.musicalbreaks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //To slide from left to right between activities
        overridePendingTransition(R.anim.anim, R.anim.anim2);
    }

    //To slide from right to left when the back button is pressed
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.backanim2, R.anim.backanim);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // To hide the pause ImageView on launch. The app will toggle between the pause
        // and play image here as and when they are clicked
        ImageView pauseImage = findViewById(R.id.pauseButton);
        pauseImage.setVisibility(View.GONE);

        // Find the Button that shows the albums category
        Button albums = findViewById(R.id.album_button);
        // Set a click listener on the album Button and launch an intent to open the AlbumActivity
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the album Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(NowPlayingActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });

        // Find the Button that shows the artists category
        Button artists = findViewById(R.id.artist_button);
        // Set a click listener on the artist Button  and launch an intent to open the ArtistActivity
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the artist Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(NowPlayingActivity.this, ArtistActivity.class);
                startActivity(artistsIntent);
            }
        });

        // Find the Button that shows the tracks category
        Button tracks = findViewById(R.id.track_button);
        // Set a click listener on the track Button and launch an intent to open the TrackActivity
        tracks.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the track Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent tracksIntent = new Intent(NowPlayingActivity.this, TrackActivity.class);
                startActivity(tracksIntent);
            }
        });

        //Retrieve the saved info in sharedPreferences and use it to set the song listed in the now-playing
        //LinearLayout view to the same as the one selected by the user in the Tracks category
        SharedPreferences pref = getSharedPreferences("MyPref",
                Context.MODE_PRIVATE);

        //Retrieve the song name and place it in the song_name TextView
        String songName = pref.getString("song_name", "Select a track");
        TextView song = findViewById(R.id.song_name);
        song.setText(songName);

        //Retrieve the artist name and place it in the artist_name TextView
        String artistName = pref.getString("artist_name", null);
        TextView artist = findViewById(R.id.artist_name);
        artist.setText(artistName);

        //Retrieve the album name and place it in the album_name TextView
        String albumName = pref.getString("album_name", null);
        TextView album = findViewById(R.id.album_name);
        album.setText(albumName);

        //Retrieve the album art work and place it in the album_art ImageView
        int albumArt = pref.getInt("album_art", 0);
        ImageView art = findViewById(R.id.album_art);
        art.setImageResource(albumArt);
    }

    public void playButton(View view) {
        // To reveal the pause ImageView on clicking the play ImageView.
        ImageView pauseImage = findViewById(R.id.pauseButton);
        pauseImage.setVisibility(View.VISIBLE);

        // and hide the play ImageView.
        ImageView playImage = findViewById(R.id.playButton);
        playImage.setVisibility(View.GONE);

//        Intent currentInfoIntent = new Intent(NowPlayingActivity.this, AlbumActivity.class);
//        startActivityForResult(currentInfoIntent );
    }

    public void pauseButton(View view) {
        // To reveal the play ImageView on clicking the pause ImageView.
        ImageView playImage = findViewById(R.id.playButton);
        playImage.setVisibility(View.VISIBLE);

        // and hide the pause ImageView.
        ImageView pauseImage = findViewById(R.id.pauseButton);
        pauseImage.setVisibility(View.GONE);
    }
}
