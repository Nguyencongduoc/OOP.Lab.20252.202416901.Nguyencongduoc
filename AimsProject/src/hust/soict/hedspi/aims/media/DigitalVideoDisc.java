package src.hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int    length; // in minutes

    public DigitalVideoDisc() {}

    public DigitalVideoDisc(String title, String category, float cost,
                            String director, int length) {
        super(title, category, cost);
        this.director = director;
        this.length   = length;
    }

    // ---- Getters / Setters ------------------------------------------
    public String getDirector() { return director; }
    public int    getLength()   { return length;   }

    public void setDirector(String director) { this.director = director; }
    public void setLength  (int    length)   { this.length   = length;   }

    // ---- Playable ---------------------------------------------------
    @Override
    public String play() {
        return String.format("Playing DVD: \"%s\" directed by %s (%d min)",
                getTitle(), director, length);
    }

    @Override
    public String toString() {
        return String.format("DigitalVideoDisc[title=\"%s\", director=%s, length=%d, cost=%.2f]",
                getTitle(), director, length, getCost());
    }
}