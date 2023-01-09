package Impl;

import Dao.SongDao;
import ModelClass.Song;
import MyExceptions.SongNotFound;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Songoperation  implements SongDao {

    public List<Song> searchBySongName(String songName) {
        List<Song> songs = new ArrayList<Song>();
        try (Connection con = Dbconnection.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from song where songName='" + songName + "'");
            while (resultSet.next()) {
                songs.add(new Song(resultSet.getInt("songId"), resultSet.getString("songName"),
                        resultSet.getString("artist"), resultSet.getString("albumName"),resultSet.getString("genre"),
                        resultSet.getString("duration").toString(), resultSet.getString("location")));
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return songs;
    }

    @Override
    public List<Song> searchByArtistName(String artist) {
        List<Song> songs2 = new ArrayList<Song>();
        try (Connection con = Dbconnection.getConnection()) {
            String query = "select * from song where artist = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, artist);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Song ID    **    Song Name       **    Artist Name        **    AlbumName        **   Genre        **   Duration ");
            System.out.println("-------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15d%-30s%-20s%-20s%-20s%-20s",resultSet.getInt("songId"), resultSet.getString("songName"),
                        resultSet.getString("artist"), resultSet.getString("albumName"),resultSet.getString("genre"),
                        resultSet.getString("duration").toString(), resultSet.getString("location"));
                System.out.println();


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return songs2;
    }

    @Override
    public List<Song> getAllSong() {
        List<Song> songs = new ArrayList<Song>();
        try (Connection con = Dbconnection.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from song order by songName asc");
            System.out.println("Song ID    **    Song Name       **    Artist Name        **    AlbumName        **   Genre        **   Duration ");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            while (resultSet.next())
            {
                System.out.printf("%-15d%-30s%-20s%-20s%-20s%-20s",resultSet.getInt("songId"), resultSet.getString("songName"),
                        resultSet.getString("artist"), resultSet.getString("albumName"),resultSet.getString("genre"),
                        resultSet.getString("duration").toString(), resultSet.getString("location"));
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return songs;
    }
    public void displayAllSongs(List<Song> all_song){
        all_song.stream().forEach(song -> System.out.println("SongID-> "+song.getSong_id()+"  Name-> "+song.getSong_name()+"  Artist-> "+song.getAlbum_name()+"  AlbumName->  "+song.getAlbum_name()+"  Genre-> "+song.getSong_genre()+"  Duration-> "+song.getSong_duration()+"minutes"));
    }
//    @Override
//    public Song getSongPathByName(String songName) {
//        try (Connection con = Dbconnection.getConnection()) {
//            String query = "select * from song where songName = ?";
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setString(1, songName);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println("Song ID    **    Song Name       **    Artist Name        **    AlbumName        **   Genre        **  Duration");
//            System.out.println("-------------------------------------------------------------------------------------------------------");
//            if (resultSet.next()) {
//
//                Song song =new Song(resultSet.getInt("songId"), resultSet.getString("songName"),
//                        resultSet.getString("artist"), resultSet.getString("albumName"),resultSet.getString("genre"),
//                        resultSet.getString("duration").toString(), resultSet.getString("location"));
//                // Song song = null;
//                return song;
//            } else {
//                throw new SongNotFound("Not Found");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }


    @Override
    public Song getSongById(int id) {
        try (Connection con = Dbconnection.getConnection()) {
            String query = "select * from song where songId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Song song =new Song(resultSet.getInt("songId"), resultSet.getString("songName"),
                        resultSet.getString("artist"), resultSet.getString("albumName"),resultSet.getString("genre"),
                        resultSet.getString("duration").toString(), resultSet.getString("location"));
                return song;
            } else {
                throw new SongNotFound("No such song Found");
            }
        } catch (SongNotFound ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }


    @Override
    public List<Song> searchByGenre(String genre) {
        List<Song> songs = new ArrayList<Song>();
        try (Connection con = Dbconnection.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from song where genre='" + genre + "'");
            System.out.println("Song ID    **    Song Name       **    Artist Name        **    AlbumName        **   Genre        **  Duration");
            System.out.println("-----------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15d%-30s%-20s%-20s%-20s%-20s",resultSet.getInt("songId"), resultSet.getString("songName"),
                        resultSet.getString("artist"), resultSet.getString("albumName"),resultSet.getString("genre"),
                        resultSet.getString("duration").toString(), resultSet.getString("location"));
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return songs;
    }

    @Override
    public  List<Song> DisplayAlbums(String album_name) {

        List<Song> songs = new ArrayList<Song>();
        try (Connection con = Dbconnection.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from song where albumName='" + album_name + "'");
            System.out.println("Song ID    **    Song Name       **    Artist Name        **    AlbumName        **   Genre        **  Duration");
            System.out.println("-----------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15d%-30s%-20s%-20s%-20s%-20s",resultSet.getInt("songId"), resultSet.getString("songName"),
                        resultSet.getString("artist"), resultSet.getString("albumName"),resultSet.getString("genre"),
                        resultSet.getString("duration").toString(), resultSet.getString("location"));
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return songs;
    }


}








