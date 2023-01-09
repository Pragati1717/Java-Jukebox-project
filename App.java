package Main;

import Dao.*;
import Impl.*;
import ModelClass.Audio;
import ModelClass.Playlist;
import ModelClass.Podcast;
import ModelClass.Song;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class App {




   public void app(Connection connection) {
        Scanner sc = new Scanner(System.in);
        SongDao songDaoimpl = new Songoperation();
        //  SongplylistInterfc songDetailsImplementation = new Songplaylist();
        PodcastDao podcastDaoimpl = new PodcastOperation();
        //  PodcastplaylistInt podcastDetailsImplementation = new Podplylist();
        PlaylistDao playlistDaoImpl = new PlaylistOperation();
        UserDao userDaoImpl = new UserOperation();
        AudioDao audioDaoimpl = new AudioOperation();

       System.out.println("\n");
       int choice;
       do {

           System.out.println("Enter your Choice :\n1.Songs Catalog \n2. podcasts catalog \n3.Playlist menu\n4.Exit");
           System.out.println("what is user's choice please enter");
           choice = sc.nextInt();

           switch (choice) {
               case 1:
                   int userchoice;
                   do {
                       System.out.println("Select operation from menu\n1.Display all Songs \n2.search by name\n3.Search by Artist\n4. Search by Genre\n5. Display album \n6 Podcast");
                       userchoice = sc.nextInt();
                       sc.nextLine();

                       switch (userchoice) {
                           case 1:
                               for (Song sng : songDaoimpl.getAllSong()) {
                                   System.out.println(sng);
                               }
                               break;
                           case 2:


                               System.out.println("Enter the name of the song ");
                               String preferred_song = sc.nextLine();
                               sc.nextLine();
                               for (Song sng : songDaoimpl.searchBySongName(preferred_song)) {
                                   System.out.println(sng);
                               }

                               break;
                           case 3:
                               System.out.println("Name of Artist");
                               String preferred_artist = sc.nextLine();
                               sc.nextLine();
                               for (Song sng : songDaoimpl.searchByArtistName(preferred_artist)) {
                                   System.out.println(sng);
                               }
                               break;
                           case 4:
                               System.out.println("Enter genre");
                               String genre = sc.next();
                               System.out.println(songDaoimpl.searchByGenre(genre));
                               break;
                           case 5:
                               System.out.println("Enter the Album Name");
                               String album1 = sc.nextLine();
                               sc.nextLine();
                               for (Song sng2 : songDaoimpl.DisplayAlbums(album1)) {
                                   System.out.println(album1);
                                   break;
                               }


                           case 6:
                               //  System.exit(0);
                               break;
                           default:
                               System.out.println("Invalid Choice");
                               break;


                       }
                   }
                   while (userchoice != 6);
               case 2:
                   int userchoice2;
                   do {
                       System.out.println("choose operation from menu\n1.Display Podcasts \n2.Search by  Name\n3.Search By Celebrity \n4.Playlist");
                       userchoice2 = sc.nextInt();
                       sc.nextLine();
                       switch (userchoice2) {
                           case 1:
                               for (Podcast pod :podcastDaoimpl.getAllPodcast()) {
                                   System.out.println(pod);
                               }
                               break;
                           case 2:
                               System.out.println("Enter the name of the podcast ");
                               String preferred_podcast = sc.nextLine();
                               sc.nextLine();
                               for (Podcast pd1 : podcastDaoimpl.searchPodcastByName(preferred_podcast)) {
                                   System.out.println(pd1);
                               }

                               break;
                           case 3:
                               System.out.println("Enter the name of the celebrity ");
                               String preferred_podcast1 = sc.nextLine();
                               sc.nextLine();
                               for (Podcast pd2 : podcastDaoimpl.searchPodcastByCelebrityName(preferred_podcast1)) {
                                   System.out.println(pd2);
                               }
                               break;
                           case 4:
                               System.out.println("Enter date");
                               String str = sc.next();

                               Date date = Date.valueOf(str);//converting string into sql date.
                               System.out.println(podcastDaoimpl.PodcastByDate(date));
                               break;
                           case 5:
                               break;
                           default:
                               System.out.println("Incorrect choice!");
                               break;
                       }
                   } while (userchoice2 != 5);

               case 3:
                   System.out.println("Playlists currently available");
                   playlistDaoImpl.displayAllPlaylists(playlistDaoImpl.showAllPlaylists());
                   int choice4;
                   do {
                       System.out.println("\nWhat do you want to do with the playlist:\n1.Add songs\n2.Delete songs\n3.Add podcast\n4.Delete podcast\n5.Add song And Podcast\n6.Create playlist\n7.View playlist content\n8.Main menu");
                       choice4 = sc.nextInt();

                       switch (choice4) {
                           case 1:
                               System.out.println("Below are all the available songs, please select playlist and song ");
                               ((Songoperation) songDaoimpl).displayAllSongs(songDaoimpl.getAllSong());
                               int songId = sc.nextInt();
                               int playlistId = sc.nextInt();
                               System.out.println("Enter audio ID based on the record table shown");
                               audioDaoimpl.displayAllAudio(audioDaoimpl.showAllaudio());
                               int audioId = sc.nextInt();
                               int podcastId = 0;
                               //  int albumId = 0;
                               Audio audio = new Audio(audioId, songId, podcastId, playlistId);
                               audioDaoimpl.addSongToPlaylist(audio);
                               break;
                           case 2:
                               System.out.println("Below are all the available Podcasts, please select playlist and podcast ");
                               ((PodcastOperation) podcastDaoimpl).displayAllPodcast(podcastDaoimpl.getAllPodcast());
                               int podcastId1 = sc.nextInt();
                               int playlistId1 = sc.nextInt();
                               System.out.println("Enter audio ID based on the record table shown");

                               audioDaoimpl.displayAllAudio(audioDaoimpl.showAllaudio());
                               int audioId1 = sc.nextInt();
                               int songId1 = 0;
                               int podcastId2 = 0;
                               //  int albumId = 0;
                               Audio audio1 = new Audio(audioId1, songId1, podcastId2, playlistId1);
                               audioDaoimpl.addPodcastToPlaylist(audio1);
                               break;
                           case 3:
                               System.out.println("Below are all the available Songs and Podcasts, please select playlist, podcast, song IDs ");
                               ((Songoperation) songDaoimpl).displayAllSongs(songDaoimpl.getAllSong());
                               ((PodcastOperation) podcastDaoimpl).displayAllPodcast(podcastDaoimpl.getAllPodcast());
                               int songId2 = sc.nextInt();
                               int podcastId3 = sc.nextInt();
                               int playlistId2 = sc.nextInt();
                               System.out.println("Enter record ID based on the record table shown");
                               audioDaoimpl.displayAllAudio(audioDaoimpl.showAllaudio());
//                                int audioId2 = sc.nextInt();
//                               // int albumId2 = 0;
//                                Audio audio2 = new Audio(audioId2, songId2, podcastId3, playlistId2);
//                                audioDaoimpl.addSongAndPodcastToPlaylist((audioId2);
//
//
//
//                            case 4:
//                                System.out.println("Available playlists for you: ");
//                                playlistDaoImpl.displayAllPlaylists(playlistDaoImpl.showAllPlaylists());
//                                System.out.println("\n");
//                                System.out.println("Please enter Playlist ID, name  to create new playlist");
//                                int playlistId3 = sc.nextInt();
//                                String playlistName = sc.next();
//                                String str = sc.next();
//                                int UserId=sc.nextInt();
//                               // Date date = Date.valueOf(str);
//                                Playlist playlist = new Playlist(playlistId3, playlistName, UserId);
//                                Playlist result = playlistDaoImpl.createPlaylist(playlistId3, playlistName, UserId);
////                                if (result) {
//                                    System.out.println("Do you want to add songs?(1 for yes,2 for No)");
//                                    int add = scanner.nextInt();
//                                    if (add == 1) {
//                                        System.out.println("Below are all the available songs, please song ");
//                                        songDAOImpl.displayAllSongs(songDAOImpl.showAllSongs());
//                                        int songId3 = scanner.nextInt();
//                                        System.out.println("Enter record ID based on the record table shown");
//                                        recordDAOImpl.displayAllRecord(recordDAOImpl.showAllRecord());
//                                        int recordId3 = scanner.nextInt();
//                                        int podcastId3 = 0;
//                                        int albumId3 = 0;
//                                        Record record3 = new Record(recordId3, songId3, podcastId3, playlistId3, albumId3);
//                                        recordDAOImpl.addSongToPlaylist(record3);
//                                    } else
//                                        System.out.println("Thank you!");
//                                }
//                                break;
//                            case 7:
//                                System.out.println("Enter name of playlist you want to view the content for");
//                                String playlistName1 = scanner.next();
//                                recordDAOImpl.viewPlaylistContent(playlistName1);
//                                break;
//                            case 8:
//                                break;
                           default:
                               System.out.println("Incorrect choice!");
                               break;
                       }
                   } while (choice4 != 8);
                   break;

               case 5:
                   System.out.println("Exiting the application. Have a nice day!!");
                   break;
               default:
                   System.out.println("Incorrect choice!");
                   break;
           }
            } while (choice != 5);
        }
    }

