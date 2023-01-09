package Impl;

import Dao.AudioDao;
import ModelClass.Audio;
import ModelClass.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AudioOperation  implements AudioDao {


    @Override
    public void displayAllAudio(List<Audio> allAudios) {
        allAudios.stream().forEach(audio -> System.out.println("Audio ID: " + audio.getAudioIdId() + "  SongID: " + audio.getSongId() + "  Podcast ID: " + audio.getPodcastId() + "  Playlist ID: " + audio.getPlaylistId()));
    }


    @Override
    public List<Audio> showAllaudio() {
        List<Audio> allAudio = new ArrayList<>();
        try (Connection connection = Dbconnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from audio");
            while (resultSet.next()) {
                Audio audio = new Audio(resultSet.getInt("audioId"), resultSet.getInt("songId"), resultSet.getInt("podcastId"),
                        resultSet.getInt("playlistId"));
                allAudio.add(audio);
            }
            return allAudio;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public Audio getAudioByID(int audioId) {
        return null;
    }

    @Override
    public boolean addSongToPlaylist(Audio audio) {

        try (Connection con = Dbconnection.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("insert into audio(audioid, songid, podcastid, playlistid) values(?,?,null,?)");
            preparedStatement.setInt(1, audio.getAudioIdId());
            preparedStatement.setInt(2, audio.getSongId());
            preparedStatement.setInt(3, audio.getPlaylistId());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Song Successfully Inserted");
            } else {
                System.out.println("Song couldn't be inserted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addPodcastToPlaylist(Audio audio) {
        try (Connection con = Dbconnection.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("insert into audio(audioid, songId, podcastId, playlistID) values(?,null,?,?)");
            preparedStatement.setInt(1, audio.getAudioIdId());
            preparedStatement.setInt(2, audio.getPodcastId());
            preparedStatement.setInt(3, audio.getPlaylistId());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Podcast Successfully Inserted");
            } else {
                System.out.println("podcast couldn't be inserted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addSongAndPodcastToPlaylist(Audio audio) {
        try (Connection con = Dbconnection.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("insert into audio(audioid, songId, podcastId, playlistID) values(?,?,?,?");
            preparedStatement.setInt(1, audio.getAudioIdId());
            preparedStatement.setInt(2, audio.getSongId());
            preparedStatement.setInt(3, audio.getPodcastId());
            preparedStatement.setInt(4, audio.getPlaylistId());

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println(" Both Song And Podcast inserted");
            } else {
                System.out.println("Not inserted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void viewPlaylistContent(String playlistName) {
        Playlist playlist;
        try (Connection con = Dbconnection.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("select p.playlistname, s.songName from playlist p join audio a on p.playlistId = a.playlistId join song s on a.songId = s.songId where p.playlistName = ?");

            preparedStatement.setString(1, playlistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Play List Name : " + resultSet.getString("playlistName") + "   Song Name : " + resultSet.getString("songName"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}

//
//        @Override
//    public boolean deleteSongFromPlaylist(String songName) {
//        return false;
//    }
//
//    @Override
//    public boolean deletePodcastFromPlaylist(String podcastName) {
//        return false;
//    }
//
//    @Override
//    public void viewPlaylistContent(String playlistName) {
//
//    }
//}
