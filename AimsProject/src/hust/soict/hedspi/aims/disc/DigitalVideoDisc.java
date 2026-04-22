package src.hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public void setTitle(String title) { this.title = title; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public int getId() { return id; }
    public static int getNbDigitalVideoDiscs() { return nbDigitalVideoDiscs; }


    /**
     * Phương thức toString để trả về thông tin chi tiết của DVD
     * Format yêu cầu: DVD - [Title] - [Category] - [Director] - [Length]: [Price] $ [cite: 982]
     */
    @Override
    public String toString() {
        return "DVD - " + title + " - " + (category != null ? category : "N/A") + " - "
                + (director != null ? director : "N/A") + " - " + length + ": " + cost + " $";
    }

    /**
     * Phương thức kiểm tra tiêu đề có khớp với từ khóa tìm kiếm hay không
     * @param title Từ khóa tìm kiếm
     * @return true nếu tiêu đề DVD chứa từ khóa (không phân biệt hoa thường)
     */
    public boolean isMatch(String title) {
        if (this.title == null || title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}