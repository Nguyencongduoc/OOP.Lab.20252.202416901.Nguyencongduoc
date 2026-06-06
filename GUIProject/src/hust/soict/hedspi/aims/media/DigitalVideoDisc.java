package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public String play() {
        StringBuilder sb = new StringBuilder();
        if (this.getLength() > 0) {
            sb.append("Playing DVD: ").append(this.getTitle()).append("\n");
            sb.append("DVD length: ").append(this.getLength()).append(" min");
        } else {
            sb.append("DVD ").append(this.getTitle()).append(" cannot be played.");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}