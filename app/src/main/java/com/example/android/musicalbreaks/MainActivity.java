package com.example.android.musicalbreaks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To slide from left to right between activities
        overridePendingTransition(R.anim.anim, R.anim.anim2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // To hide the pause ImageView on launch. The app will toggle between the pause
        // and play image here as and when they are clicked
        ImageView pauseImage = findViewById(R.id.pauseButton);
        pauseImage.setVisibility(View.GONE);

        // Find the layout that shows the song currently playing
        LinearLayout current = findViewById(R.id.now_playing);

        // Set a click listener on the layout and launch an intent to open the NowPlayingActivity
        current.setOnClickListener(new View.OnClickListener() {
            // When the currently playing layout is clicked on the NowPlaying activity will open
            @Override
            public void onClick(View view) {
                Intent currentIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(currentIntent);
            }
        });

        // Find the View that shows the albums category
        TextView albums = findViewById(R.id.albums);

        // Set a click listener on the albums View and launch an intent to open the AlbumActivity
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the albums View is clicked on.
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });

        // Find the View that shows the artists category
        TextView artists = findViewById(R.id.artists);

        // Set a click listener on the artists View and launch an intent to open the ArtistActivity
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the artista View is clicked on.
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(artistsIntent);
            }
        });

        // Find the View that shows the tracks category
        TextView tracks = findViewById(R.id.tracks);

        // Set a click listener on the tracks View and launch an intent to open the TrackActivity
        tracks.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the tracks View is clicked on.
            @Override
            public void onClick(View view) {
                Intent tracksIntent = new Intent(MainActivity.this, TrackActivity.class);
                startActivity(tracksIntent);
            }
        });

        //Retrieve the saved info in sharedPreferences and use it to set the song listed in the now-playing
        //LinearLayout view to the same as the one selected by the user in the Tracks category
        SharedPreferences pref = getSharedPreferences("MyPref",
                Context.MODE_PRIVATE);

        //Retrieve the song name and place it in the song_name TextView
        String songName = pref.getString("song_name", null);
        TextView song = findViewById(R.id.song_name);
        song.setText(songName);

        //Retrieve the artist name and place it in the artist_name TextView
        String artistName = pref.getString("artist_name", "Select a track to play");
        TextView artist = findViewById(R.id.artist_name);
        artist.setText(artistName);

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
