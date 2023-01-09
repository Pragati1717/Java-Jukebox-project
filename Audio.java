package ModelClass;

public class Audio {
    private int audioId;
    private int songId;
    private int podcastId;
    private int playlistId;

    public Audio(int audioId, int songId, int podcastId, int playlistId) {
        this.audioId = audioId;
        this.songId = songId;
        this.podcastId = podcastId;
        this.playlistId = playlistId;

    }

    public int getAudioIdId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId= audioId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "audioId=" + audioId +
                ", songId=" + songId +
                ", podcastId=" + podcastId +
                ", playlistId=" + playlistId +
                '}';
    }
}
