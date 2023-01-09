package Dao;

import ModelClass.Audio;

import java.util.List;

public interface AudioDao {



    void displayAllAudio(List<Audio> allAudios);
    List<Audio> showAllaudio();
    Audio getAudioByID(int audioId);
    boolean addSongToPlaylist(Audio audio);
    boolean addPodcastToPlaylist(Audio audio);
    boolean addSongAndPodcastToPlaylist(Audio audio);
//    boolean deleteSongFromPlaylist(String songName);
//    boolean deletePodcastFromPlaylist(String podcastName);
    void viewPlaylistContent(String playlistName);
}
