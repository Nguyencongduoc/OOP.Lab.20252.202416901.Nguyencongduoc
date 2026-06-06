package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {

    private int    id;
    private String title;
    private String category;
    private float  cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id       = id;
        this.title    = title;
        this.category = category;
        this.cost     = cost;
    }

    // ── Accessors ─────────────────────────────────────────────────────────────

    public int    getId()       { return id;       }
    public String getTitle()    { return title;    }
    public void   setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public float  getCost()     { return cost;     }

    // ── equals(): two Media are equal iff same title AND same cost ────────────

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        // Guard against ClassCastException — use instanceof instead
        if (!(obj instanceof Media)) return false;

        try {
            Media other = (Media) obj;

            // Guard against NullPointerException on title
            if (this.title == null || other.title == null) {
                return this.title == other.title; // both null → equal
            }

            return this.title.equalsIgnoreCase(other.title)
                    && Float.compare(this.cost, other.cost) == 0;

        } catch (NullPointerException e) {
            // Defensive catch: should not be reached due to null-checks above
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = (title != null ? title.toLowerCase().hashCode() : 0);
        result = 31 * result + Float.floatToIntBits(cost);
        return result;
    }

    // ── compareTo(): order by title then cost ─────────────────────────────────

    @Override
    public int compareTo(Media other) {
        // Guard against NullPointerException
        if (other == null) {
            throw new NullPointerException("Cannot compare to null Media.");
        }

        // Guard against ClassCastException — guaranteed by generics here,
        // but we add instanceof check for safety when called via raw types.
        if (!(other instanceof Media)) {
            throw new ClassCastException(
                    "Cannot compare Media with " + other.getClass().getName());
        }

        try {
            // Primary sort: title (alphabetical, case-insensitive)
            int titleCmp = 0;
            if (this.title != null && other.title != null) {
                titleCmp = this.title.compareToIgnoreCase(other.title);
            } else if (this.title == null && other.title != null) {
                titleCmp = -1;
            } else if (this.title != null) {
                titleCmp = 1;
            }

            if (titleCmp != 0) return titleCmp;

            // Secondary sort: cost (ascending)
            return Float.compare(this.cost, other.cost);

        } catch (NullPointerException e) {
            // Should not occur given the null-checks above
            return 0;
        }
    }

    // ── toString (abstract — subclasses provide their own) ───────────────────
    @Override
    public abstract String toString();
}