package Impl;

import Dao.PlaylistDao;
import ModelClass.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistOperation implements PlaylistDao {
    public List<Playlist> showAllPlaylists()
    {
        List<Playlist> allPlaylists = new ArrayList<Playlist>();
        try (Connection connection = Dbconnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from playlist");
            System.out.println("Playlist ID **          Playlist Name       **              User Id         ");
            System.out.println("-----------------------------------------------------------------");
            while (resultSet.next())
            {
                System.out.printf("%-15d%-30s%-20d",resultSet.getInt("playlistID"),resultSet.getString("playlistName"),resultSet.getInt("userId"));
                System.out.println();
            }
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        return allPlaylists;
    }

    @Override
    public void displayAllPlaylists(List<Playlist> allPlaylist) {
        allPlaylist.stream().forEach(playlist -> System.out.println("PlaylistID: "+playlist.getPlaylist_id()+"  Name: "+playlist.getPlaylist_name()+"  userId: "+playlist.getUser_id()));
    }

    @Override
    public Playlist getPlaylistByID(int playlistId) {
        try (Connection con = Dbconnection.getConnection()) {
            String query = "select * from playlist where playlistId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, playlistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Playlist playList = new Playlist(resultSet.getInt("playlistID"), resultSet.getString("playlistName"),
                        resultSet.getInt("userId"));
                return playList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    @Override
    public Playlist createPlaylist(int playlistId, String playListName, int UserId) {

        try (Connection connection = Dbconnection.getConnection()) {
            String query = "insert into playlist(playlistId,playlistName,userId) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, playlistId);
            preparedStatement.setString(2, playListName);
            preparedStatement.setInt(3, UserId);

            int rowsaffected = preparedStatement.executeUpdate();
            {
                if (rowsaffected > 0) {
                    System.out.println("Playlist Created succesfully");
                } else {
                    System.out.println("Playlist not created");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



        public void deletePlaylist(int playlistId){
            try (Connection connection = Dbconnection.getConnection()){
                String query="delete from playlist where playlistId=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, playlistId);
                int rowsaffected = preparedStatement.executeUpdate();
                {
                    if (rowsaffected > 0) {
                        System.out.println("Playlist deleted successfully");
                    } else {
                        System.out.println("Playlist couldn't be deleted");
                    }
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }




}
