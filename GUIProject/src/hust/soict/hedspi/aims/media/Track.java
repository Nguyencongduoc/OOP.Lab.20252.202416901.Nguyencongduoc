package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {

    private String title;
    private int    length;

    public Track(String title, int length) {
        this.title  = title;
        this.length = length;
    }

    public String getTitle()  { return title;  }
    public int    getLength() { return length; }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + title
                    + " (Length: " + length + ")");
        } else {
            System.err.println("ERROR: Track '" + title
                    + "' length is non-positive!");
            throw new PlayerException(
                    "ERROR: Track '" + title + "' length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        return this.length == other.length
                && this.title != null
                && this.title.equalsIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Track: " + title + " (Length: " + length + ")";
    }
}