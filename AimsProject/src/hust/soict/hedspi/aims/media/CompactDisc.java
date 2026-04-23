package src.hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director); // length CD được tính động
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) tracks.add(track);
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    // Tính tổng chiều dài các Track
    @Override
    public int getLength() {
        int sum = 0;
        for (Track track : tracks) sum += track.getLength();
        return sum;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle() + " by " + artist);
        for (Track track : tracks) {
            track.play();
        }
    }
}