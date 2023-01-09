package Dao;

import ModelClass.Song;

import java.util.List;

public interface SongDao {

    List<Song> searchBySongName(String songName);
    List<Song> searchByArtistName(String songName);
    List<Song> getAllSong();
   // Song getSongPathByName(String songName);
    Song getSongById(int id);
    List<Song> searchByGenre(String genre);

    List<Song> DisplayAlbums(String album_name);
}

