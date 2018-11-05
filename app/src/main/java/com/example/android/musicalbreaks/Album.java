package com.example.android.musicalbreaks;
/**
 * {@link Album} represents a single album.
 * Each object has 3 properties: album name, artist name, and album art image resource ID.
 */
public class Album {

    // Name of the album (e.g. Off The Wall, Dark Side of the Moon, Abbey Road)
    private String mAlbumName;

    // Name of artist (e.g. Michael Jackson, Pink Floyd, The Beatles)
    private String mArtistName;

    // Drawable album art resource ID
    private int mAlbumArtResourceId;

    /*
     * Create a new Album object.
     *
     * @param albumName is the name of the album (e.g. Abbey Road)
     * @param artistName is the corresponding album artist (e.g. The Beatles)
     * @param albumArtID is the drawable reference ID that corresponds to the album art
     * */
    public Album(String albumName, String artistName, int albumArtResourceID)
    {
        mAlbumName = albumName;
        mArtistName = artistName;
        mAlbumArtResourceId = albumArtResourceID;
    }

    /**
     * Get the name of the album
     */
    public String getAlbumName() {
        return mAlbumName;
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


}