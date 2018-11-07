package com.example.android.musicalbreaks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_list);

        //To customise home button in action bar
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_action_home);

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

        // Find the layout that shows the song currently playing
        LinearLayout current = findViewById(R.id.now_playing);
        // Set a click listener on the layout  and launch an intent to open the NowPlayingActivity
        current.setOnClickListener(new View.OnClickListener() {
            // When the currently playing layout is clicked on the NowPlaying activity will open
            @Override
            public void onClick(View view) {
                Intent currentIntent = new Intent(ArtistActivity.this, NowPlayingActivity.class);
                startActivity(currentIntent);
            }
        });

        // Find the Button that shows the albums category
        Button albums = findViewById(R.id.album_button);
        // Set a click listener on the album Button and launch an intent to open the AlbumActivity
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the album Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(ArtistActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });

        // Find the Button that shows the tracks category
        Button tracks = findViewById(R.id.track_button);
        // Set a click listener on the track Button and launch an intent to open the TrackActivity
        tracks.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the track Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent tracksIntent = new Intent(ArtistActivity.this, TrackActivity.class);
                startActivity(tracksIntent);
            }
        });

        // To hide the pause ImageView on launch. The app will toggle between the pause
        // and play image here as and when they are clicked
        ImageView pauseImage = findViewById(R.id.pauseButton);
        pauseImage.setVisibility(View.GONE);

        // Create a list of artists
        ArrayList<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist("The Beatles"));
        artists.add(new Artist("Alt-J"));
        artists.add(new Artist("Pink Floyd"));
        artists.add(new Artist("Michael Jackson"));
        artists.add(new Artist("Lou Reed"));

        // Create an {@link ArtistAdapter}, whose data source is a list of {@link Artist}s. The
        // adapter knows how to create list items for each item in the list.
        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called artist_list, which is declared in the
        // artist_list.xml file.
        ListView listView = (ListView) findViewById(R.id.artist_list);

        // Make the {@link ListView} use the {@link ArtistAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Artist} in the list.
        listView.setAdapter(adapter);

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
