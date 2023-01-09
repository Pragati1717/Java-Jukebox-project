package Dao;

import ModelClass.Playlist;

import java.util.List;

public interface PlaylistDao {

    List<Playlist> showAllPlaylists();
    void displayAllPlaylists(List<Playlist> allPlaylist);
    Playlist getPlaylistByID(int playlistId);


    Playlist createPlaylist(int playlistId, String playListName, int UserId);
    public void deletePlaylist(int playlistId);

}

