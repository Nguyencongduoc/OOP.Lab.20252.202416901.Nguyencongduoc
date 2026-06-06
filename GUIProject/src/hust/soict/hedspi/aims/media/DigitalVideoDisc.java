package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    // Overloaded constructor for code that doesn't provide id
    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        this(0, title, category, cost, length, director);
    }

    @Override
    public String play() {
        if (this.getLength() > 0) {
            String msg = "Playing DVD: " + this.getTitle() + " (Length: " + this.getLength() + ")";
            System.out.println(msg);
            return msg;
        } else {
            String msg = "DVD " + this.getTitle() + " cannot be played.";
            System.out.println(msg);
            return msg;
        }
    }
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}