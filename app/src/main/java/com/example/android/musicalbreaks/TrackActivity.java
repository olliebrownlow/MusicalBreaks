package com.example.android.musicalbreaks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list);

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
                Intent currentIntent = new Intent(TrackActivity.this, NowPlayingActivity.class);
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
                Intent albumsIntent = new Intent(TrackActivity.this, AlbumActivity.class);
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
                Intent artistsIntent = new Intent(TrackActivity.this, ArtistActivity.class);
                startActivity(artistsIntent);
            }
        });

        // To hide the pause ImageView on launch. The app will toggle between the pause
        // and play image here as and when they are clicked
        ImageView pauseImage = findViewById(R.id.pauseButton);
        pauseImage.setVisibility(View.GONE);

        // Create a list of tracks
        final ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Come Together", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Something", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Maxwell's Silver Hammer", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Oh! Darling", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Octopus's Garden", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("I Want You (She's So Heavy)", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Here Comes the Sun", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Because", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("You Never Give Me Your Money", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Sun King", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Mean Mr. Mustard", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Polythene Pam", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("She Came In Through the Bathroom Window", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Golden Slumbers", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Carry That Weight", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("The End", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Her Majesty", "The Beatles", R.drawable.abbey_road, "Abbey Road"));
        tracks.add(new Track("Intro", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Interlude 1 (Ripe & Ruin)", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Tessellate", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Breezeblocks", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Interlude 2 (Guitar)", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Something Good", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Dissolve Me", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Matilda", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Ms", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Fitzpleasure", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Interlude 3 (Piano)", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Bloodfood", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Taro", "Alt-J", R.drawable.an_awesome_wave, "An Awesome Wave"));
        tracks.add(new Track("Atom Heart Mother", "Pink Floyd", R.drawable.atom_heart_mother, "Atom Heart Mother"));
        tracks.add(new Track("If", "Pink Floyd", R.drawable.atom_heart_mother, "Atom Heart Mother"));
        tracks.add(new Track("Summer '68", "Pink Floyd", R.drawable.atom_heart_mother, "Atom Heart Mother"));
        tracks.add(new Track("Fat Old Sun", "Pink Floyd", R.drawable.atom_heart_mother, "Atom Heart Mother"));
        tracks.add(new Track("Alan's Psychedelic Breakfast", "Pink Floyd", R.drawable.atom_heart_mother, "Atom Heart Mother"));
        tracks.add(new Track("Don't Stop 'Til You Get Enough", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("Rock With You", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("Workin' Day and Night", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("Get on the Floor", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("Off the Wall", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("Girlfriend", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("She's Out of My Life", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("I Can't Help It", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("It's the Falling in Love", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("Burn This Disco Out", "Michael Jackson", R.drawable.off_the_wall, "Off the Wall"));
        tracks.add(new Track("Speak to Me / Breathe", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("On the Run", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("Time", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("The Great Gig In the Sky", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("Money", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("Us and Them", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("Any Colour You Like", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("Brain Damage", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("Eclipse", "Pink Floyd", R.drawable.the_dark_side_of_the_moon, "The Dark Side of the Moon"));
        tracks.add(new Track("In the Flesh?", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("The Thin Ice", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Another Brick In the Wall, Part 1", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("The Happiest Days of Our Lives", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Another Brick In the Wall, Part 2", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Mother", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Goodbye Blue Sky", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Empty Spaces", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Young Lust", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("One of My Turns", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Don't Leave Me Now", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Another Brick In the Wall, Part 3", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Goodbye Cruel World", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Hey You", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Is There Anybody Out There?", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Nobody Home", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Vera", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Bring the Boys Back Home", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Comfortably Numb", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("The Show Must Go On", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("In the Flesh", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Run Like Hell", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Waiting for the Worms ", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Stop", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("The Trial", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Outside the Wall", "Pink Floyd", R.drawable.the_wall, "The Wall"));
        tracks.add(new Track("Wanna Be Startin' Somethin'", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("Baby Be Mine", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("The Girl Is Mine", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("Thriller", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("Beat It", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("Billie Jean", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("Human Nature", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("P.Y.T (Pretty Young Thing)", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("The Lady In My Life", "Michael Jackson", R.drawable.thriller, "Thriller"));
        tracks.add(new Track("Vicious", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Andy's Chest", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Perfect Day", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Hangin' Round", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Walk on the Wild Side", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Make Up", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Satellite of Love", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Wagon Wheel", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("New York Telephone Conversation", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("I'm So Free", "Lou Reed", R.drawable.transformer, "Transformer"));
        tracks.add(new Track("Goodnight Ladies", "Lou Reed", R.drawable.transformer, "Transformer"));

        // Create an {@link TrackAdapter}, whose data source is a list of {@link Track}s. The
        // adapter knows how to create list items for each item in the list.
        final TrackAdapter adapter = new TrackAdapter(this, tracks);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called track_list, which is declared in the
        // track_list.xml file.
        ListView listView = findViewById(R.id.track_list);

        // Make the {@link ListView} use the {@link TrackAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Track} in the list.
        listView.setAdapter(adapter);

        // Set an item click listener on the {@link Track} object
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // Create sharedPreferences and an editor to save data to be used from other activities
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            //set an onItemClick listener on the track selected by the user
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                //get information about the selected track
                String track = tracks.get(position).getTrackName();
                String artist = tracks.get(position).getArtistName();
                int art = tracks.get(position).getAlbumArtResourceId();
                String album = tracks.get(position).getAlbumName();

                //save info about the track to sharedPreferences
                editor.putString("song_name", track);
                editor.putString("artist_name", artist);
                editor.putString("album_name", album);
                editor.putInt("album_art", art);
                editor.apply();

                //open the now playing activity
                Intent currentInfoIntent = new Intent(TrackActivity.this, NowPlayingActivity.class);
                startActivity(currentInfoIntent);
            }
        });

        //Retrieve the saved info in sharedPreferences and use it to set the song listed in the now-playing
        //LinearLayout view to the same as the one selected by the user
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
