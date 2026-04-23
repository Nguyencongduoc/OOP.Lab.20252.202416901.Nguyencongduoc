package src.hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // 1. So sánh tiêu đề theo bảng chữ cái (bỏ qua hoa/thường)
        int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());

        // Nếu tiêu đề khác nhau thì trả về kết quả luôn
        if (titleDiff != 0) {
            return titleDiff;
        }

        // 2. Nếu tiêu đề giống nhau, so sánh giá (Sắp xếp giảm dần nên để m2 so sánh với m1)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}