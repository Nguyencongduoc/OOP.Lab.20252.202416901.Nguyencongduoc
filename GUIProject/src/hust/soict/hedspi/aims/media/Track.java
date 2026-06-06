package hust.soict.hedspi.aims.media;

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
    public String play() {
        StringBuilder sb = new StringBuilder();
        if (this.getLength() > 0) {
            sb.append("Playing Track: ").append(title).append(" (Length: ").append(length).append(" min)");
        } else {
            sb.append("Track ").append(title).append(" cannot be played.");
        }
        return sb.toString();
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
    @Override
    public String toString() {
        return "Track: " + title + " (Length: " + length + ")";
    }
}