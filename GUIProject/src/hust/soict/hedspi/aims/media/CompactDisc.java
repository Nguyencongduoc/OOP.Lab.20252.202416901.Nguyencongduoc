package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director); // length CD được tính động
        this.artist = artist;
    }

    // Overloaded constructor for code that provides artist and length
    public CompactDisc(String title, String category, float cost, String artist, int length) {
        super(0, title, category, cost, length, "");
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
    public String play() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playing CD: ").append(getTitle()).append(" by ").append(artist);
        System.out.println(sb.toString());
        for (Track track : tracks) {
            String tmsg = track.play();
            sb.append("\n").append(tmsg);
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory())
                .append(" - ").append(getArtist()).append(" - ").append(getDirector())
                .append(" - ").append(getLength()).append(": ").append(getCost()).append(" $\n");
        sb.append("   Tracks:\n");
        for (Track t : tracks) {
            sb.append("      ").append(t.toString()).append("\n");
        }
        return sb.toString();
    }
}