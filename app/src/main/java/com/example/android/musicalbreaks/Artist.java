package com.example.android.musicalbreaks;

/**
 * {@link Artist} represents a single artist.
 * Each object has 1 property: artist name
 */
public class Artist {

    // Name of artist (e.g. Michael Jackson, Pink Floyd, The Beatles)
    private String mArtistName;

    /*
     * Create a new Artist object.
     *
     * @param artistName is the corresponding album artist (e.g. The Beatles)
     * */
    public Artist(String artistName) {

        mArtistName = artistName;
    }

    /**
     * Get the name of the artist
     */
    public String getArtistName() {
        return mArtistName;
    }

}
