package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(int id, String title, String category,
                            float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD '" + getTitle()
                    + "' length is non-positive!");
            throw new PlayerException(
                    "ERROR: DVD '" + getTitle() + "' length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory()
                + " - " + getDirector() + " - " + getLength()
                + ": " + getCost() + " $";
    }
}