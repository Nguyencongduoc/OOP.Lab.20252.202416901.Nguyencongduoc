package src.hust.soict.hedspi.aims.media;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private int    length; // in minutes

    public CompactDisc() {}

    public CompactDisc(String title, String category, float cost,
                       String artist, int length) {
        super(title, category, cost);
        this.artist = artist;
        this.length = length;
    }

    // ---- Getters / Setters ------------------------------------------
    public String getArtist() { return artist; }
    public int    getLength() { return length; }

    public void setArtist(String artist) { this.artist = artist; }
    public void setLength(int    length) { this.length = length; }

    // ---- Playable ---------------------------------------------------
    @Override
    public String play() {
        return String.format("Playing CD: \"%s\" by %s (%d min)", getTitle(), artist, length);
    }

    @Override
    public String toString() {
        return String.format("CompactDisc[title=\"%s\", artist=%s, length=%d, cost=%.2f]",
                getTitle(), artist, length, getCost());
    }
}