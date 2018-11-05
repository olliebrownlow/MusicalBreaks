package com.example.android.musicalbreaks;
/**
 * {@link Track} represents a single track.
 * Each object has 4 properties: track name, artist name, album art image resource ID and album name.
 */
public class Track {

    // Name of the track (e.g. Don't Stop 'Til You Get Enough, Money, Because)
    private String mTrackName;

    // Name of artist (e.g. Michael Jackson, Pink Floyd, The Beatles)
    private String mArtistName;

    // Drawable album art resource ID
    private int mAlbumArtResourceId;

    // Name of the album (e.g. Off The Wall, Dark Side of the Moon, Abbey Road)
    private String mAlbumName;

    /*
     * Create a new Track object.
     *
     * @param trackName is the name of the track (e.g. Because)
     * @param artistName is the corresponding album artist (e.g. The Beatles)
     * @param albumArtID is the drawable reference ID that corresponds to the album art
     * @param albumName is the name of the album (e.g. Abbey Road)
     * */
    public Track (String trackName, String artistName, int albumArtResourceID, String albumName)
    {
        mTrackName = trackName;
        mArtistName = artistName;
        mAlbumArtResourceId = albumArtResourceID;
        mAlbumName = albumName;
    }

    /**
     * Get the name of the track
     */
    public String getTrackName() {
        return mTrackName;
    }

    /**
     * Get the name of the artist
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the album art ID
     */
    public int getAlbumArtResourceId() {
        return mAlbumArtResourceId;
    }

    /**
     * Get the name of the album
     */
    public String getAlbumName() {
        return mAlbumName;
    }

}