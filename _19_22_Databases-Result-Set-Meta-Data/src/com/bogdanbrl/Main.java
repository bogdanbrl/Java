package com.bogdanbrl;

import java.util.List;
import com.bogdanbrl.model.Artist;
import com.bogdanbrl.model.Datasource;
import com.bogdanbrl.model.SongArtist;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(5);
        if(artists == null) {
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Carole King", Datasource.ORDER_BY_ASC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if(songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("\t\t\tArtist name = " + artist.getArtistName() +
                " Album name = " + artist.getAlbumName() +
                " Track = " + artist.getTrack());
        }
        System.out.println("\n");

        datasource.querySongsMetadata();

        datasource.close();
    }
}


















