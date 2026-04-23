package src.hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // 1. So sánh giá (Giảm dần: m2 so với m1)
        int costDiff = Float.compare(m2.getCost(), m1.getCost());

        // Nếu giá khác nhau thì trả về kết quả luôn
        if (costDiff != 0) {
            return costDiff;
        }

        // 2. Nếu giá bằng nhau, so sánh tiêu đề theo bảng chữ cái
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}