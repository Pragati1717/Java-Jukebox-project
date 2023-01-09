package ModelClass;

public class Song {
    private int song_id;
    private String song_name,artist_name,album_name,song_duration,song_path,song_genre;
    public Song(){}
    public Song(int song_id,String song_name,String artist_name,String album_name,String song_genre,String song_duration,String song_path)
    {
        this.song_id=song_id;
        this.song_name=song_name;
        this.artist_name=artist_name;
        this.album_name=album_name;
        this.song_genre=song_genre;
        this.song_duration=song_duration;
        this.song_path=song_path;
    }
    public int getSong_id()
    {
        return song_id;
    }
    public String getSong_name()
    {
        return song_name;
    }
    public String getArtist_name()
    {
        return artist_name;
    }
    public String getAlbum_name()
    {
        return album_name;
    }
    public String getSong_duration()
    {
        return song_duration;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public void setSong_duration(String song_duration) {
        this.song_duration = song_duration;
    }

    public String getSong_path() {
        return song_path;
    }

    public void setSong_path(String song_path) {
        this.song_path = song_path;
    }

    public String getSong_genre() {
        return song_genre;
    }

    public void setSong_genre(String song_genre) {
        this.song_genre = song_genre;
    }

    @Override
    public String toString() {
        return
                "song_id=" + song_id +
                        ",    song_name='" + song_name + '\'' +
                        ",    artist_name='" + artist_name + '\'' +
                        ",    album_name='" + album_name + '\'' +
                        ",    song_duration='" + song_duration + '\'' +
                        ",    song_genre='" + song_genre + '\''
                ;
    }
}





