package Impl;

import Dao.PodcastDao;
import ModelClass.Podcast;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodcastOperation  implements PodcastDao {
    public List<Podcast> showAllPodcast() {      //show all podcasts
        List<Podcast> allPodcasts = new ArrayList<>();
        try (Connection con = Dbconnection.getConnection()) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from podcast");
            while (resultSet.next()) {
                Podcast podcast = new Podcast(resultSet.getInt("podcastId"), resultSet.getString("podcastName"),
                        resultSet.getString("celebrity"),
                        resultSet.getDate("date"), resultSet.getString("location"));
                allPodcasts.add(podcast);
            }
            return allPodcasts;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public void displayAllPodcast(List<Podcast> allPodcast) {
        allPodcast.stream().forEach(podcast -> System.out.println("podcastId: " + podcast.getPodcastId() + "  Name: " + podcast.getPodcastName() + "  Celebrity: " + podcast.getCelebrity() + " Date of recording: " + podcast.getDate() + "  Location: " + podcast.getLocation()));
    }

    public List<Podcast> searchPodcastByName(String podcastName) {
        List<Podcast> all_podcasts = new ArrayList<Podcast>();
        try (Connection con = Dbconnection.getConnection()) {
            String query = "select * from podcast where podcastName = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, podcastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                System.out.printf("%-15d%-30s%-20s%-20s%-20s", resultSet.getInt("PodcastId"),
//                        resultSet.getString("PodcastName"), resultSet.getString("celebrity"),
//                        resultSet.getDate("date"), resultSet.getString("location"));
//                ;
                System.out.print( resultSet.getInt("podcastId"+    "\t"));
                System.out.print( resultSet.getString("PodcastName" +   "\t"));
                System.out.print(resultSet.getString("celebrity"  + "\t"));
                System.out.println(       resultSet.getDate("date"  + "\t"));
                //resultSet.getString("location"));
                ;
                System.out.println();
                return all_podcasts;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public List<Podcast> searchPodcastByCelebrityName(String celebrityName) {
        List<Podcast> all_podcasts = new ArrayList<Podcast>();
        try (Connection con = Dbconnection.getConnection()) {
            String query = "select * from podcast where celebrity = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, celebrityName);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Podcast ID  **    Podcast Name    **      Celebrity   **     Date  **    ");
            System.out.println("-------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15d%-30s%-20s%-20s", resultSet.getInt("PodcastId"),
                        resultSet.getString("PodcastName"), resultSet.getString("celebrity"),
                        resultSet.getDate("date"));
                ;
                System.out.println();
                return all_podcasts;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }




    public Podcast getPodcastById(int id) {
        List<Podcast> all_podcasts = new ArrayList<Podcast>();

        try (Connection con = Dbconnection.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from podcast where PodcastId=?");
            System.out.println("Podcast ID    **    Release Date      **    Podcast Name      **     Celebrity   **     Duration");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15d%-30s%-20s%-20s%-20s", resultSet.getInt("PodcastId"),
                        resultSet.getString("PodcastName"), resultSet.getString("celebrity"),
                        resultSet.getDate("date"), resultSet.getString("location"));
                ;
                System.out.println();

                return (Podcast) all_podcasts;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Podcast> PodcastByDate(java.util.Date date) {

        return null;
    }
    @Override
    public List<Podcast> PodcastByDate(Date date) {
        List<Podcast> all_podcasts = new ArrayList<Podcast>();
        try (Connection con = Dbconnection.getConnection()) {
            String query = "select * from podcast where date = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Podcast ID    **    Podcast Name    **     Celebrity   **     Date");
            System.out.println("-------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15d%-30s%-20s%-20s", resultSet.getInt("PodcastId"),
                        resultSet.getString("PodcastName"), resultSet.getString("celebrity"),
                        resultSet.getDate("date"));
                ;
                System.out.println();
                return (List<Podcast>) all_podcasts;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }




    public List<Podcast> getAllPodcast() {
        List<Podcast> all_podcasts = new ArrayList<Podcast>();
        List<Podcast> podcastsList = new ArrayList<Podcast>();
        try (Connection con = Dbconnection.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from podcast ");
            System.out.println("Podcast ID          **    Podcast Name      **     Celebrity   **     Date");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15d%-30s%-20s%-20s", resultSet.getInt("podcastId"),
                        resultSet.getString("PodcastName"), resultSet.getString("celebrity"),
                        resultSet.getDate("date"));
                ;
                System.out.println();

                return all_podcasts;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}