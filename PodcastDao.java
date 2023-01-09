package Dao;

import ModelClass.Podcast;

import java.util.Date;
import java.util.List;

public interface PodcastDao {
    List<Podcast> showAllPodcast();
    List<Podcast> searchPodcastByName(String podcastName);
    List<Podcast> searchPodcastByCelebrityName(String celebrityName);

    List<Podcast> PodcastByDate(java.sql.Date date);

    List<Podcast> getAllPodcast();
    Podcast getPodcastById(int id);
    List<Podcast> PodcastByDate(Date date);
    void displayAllPodcast(List<Podcast> allPodcast);
}
