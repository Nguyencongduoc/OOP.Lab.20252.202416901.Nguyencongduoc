package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable {

    private String          artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category,
                       float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) tracks.add(track);
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    @Override
    public int getLength() {
        int sum = 0;
        for (Track t : tracks) sum += t.getLength();
        return sum;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + getTitle() + " by " + artist);

            Iterator<Track> iter = tracks.iterator();
            while (iter.hasNext()) {
                Track nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    // Log which track failed, then re-throw so the caller knows
                    System.err.println("Track playback failed: " + e.getMessage());
                    throw e;
                }
            }
        } else {
            System.err.println("ERROR: CD '" + getTitle()
                    + "' length is non-positive!");
            throw new PlayerException(
                    "ERROR: CD '" + getTitle() + "' length is non-positive!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory())
                .append(" - ").append(artist).append(" - ").append(getDirector())
                .append(" - ").append(getLength()).append(": ").append(getCost())
                .append(" $\n   Tracks:\n");
        for (Track t : tracks) sb.append("      ").append(t).append("\n");
        return sb.toString();
    }
}