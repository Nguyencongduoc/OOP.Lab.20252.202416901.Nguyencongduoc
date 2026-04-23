package src.hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + title + " (Length: " + length + ")");
        } else {
            System.out.println("Track " + title + " cannot be played.");
        }
    }
    @Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra cùng vùng nhớ
        if (this == obj) {
            return true;
        }

        // 2. Kiểm tra kiểu đối tượng để tránh lỗi ClassCastException
        if (!(obj instanceof Track)) {
            return false;
        }

        // 3. Ép kiểu an toàn và so sánh cả title và length
        Track other = (Track) obj;
        if (this.length == other.getLength()
                && this.title != null
                && this.title.equalsIgnoreCase(other.getTitle())) {
            return true;
        }

        return false;
    }
}