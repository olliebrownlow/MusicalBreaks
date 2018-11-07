package com.example.android.musicalbreaks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);

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
                Intent currentIntent = new Intent(AlbumActivity.this, NowPlayingActivity.class);
                startActivity(currentIntent);
            }
        });

        // Find the Button that shows the artists category
        Button artists = findViewById(R.id.artist_button);
        // Set a click listener on the artist Button and launch an intent to open the ArtistActivity
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the artist Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(AlbumActivity.this, ArtistActivity.class);
                startActivity(artistsIntent);
            }
        });

        // Find the Button that shows the tracks category
        Button tracks = findViewById(R.id.track_button);
        // Set a click listener on the track Button  and launch an intent to open the TrackActivity
        tracks.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the track Button is clicked on.
            @Override
            public void onClick(View view) {
                Intent tracksIntent = new Intent(AlbumActivity.this, TrackActivity.class);
                startActivity(tracksIntent);
            }
        });

        // To hide the pause ImageView on launch. The app will toggle between the pause
        // and play image here as and when they are clicked
        ImageView pauseImage = findViewById(R.id.pauseButton);
        pauseImage.setVisibility(View.GONE);

        // Create a list of albums
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("Abbey Road", "The Beatles", R.drawable.abbey_road));
        albums.add(new Album("An Awesome Wave", "Alt-J", R.drawable.an_awesome_wave));
        albums.add(new Album("Atom Heart Mother", "Pink Floyd", R.drawable.atom_heart_mother));
        albums.add(new Album("Off the Wall", "Michael Jackson", R.drawable.off_the_wall));
        albums.add(new Album("The Dark Side of the Moon", "Pink Floyd", R.drawable.the_dark_side_of_the_moon));
        albums.add(new Album("The Wall", "Pink Floyd", R.drawable.the_wall));
        albums.add(new Album("Thriller", "Michael Jackson", R.drawable.thriller));
        albums.add(new Album("Transformer", "Lou Reed", R.drawable.transformer));

        // Create an {@link AlbumAdapter}, whose data source is a list of {@link Album}s. The
        // adapter knows how to create list items for each item in the list.
        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called album_list, which is declared in the
        // album_list.xml file.
        ListView listView = findViewById(R.id.album_list);

        // Make the {@link ListView} use the {@link AlbumAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Album} in the list.
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
