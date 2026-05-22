package src.hust.soict.hedspi.aims.media;

import java.util.Objects;

public abstract class Media {
    private static int idCounter = 0;

    private int     id;
    private String  title;
    private String  category;
    private float   cost;

    // ---- Constructors -----------------------------------------------
    public Media() {
        this.id = ++idCounter;
    }

    public Media(String title, String category, float cost) {
        this();
        this.title    = title;
        this.category = category;
        this.cost     = cost;
    }

    // ---- Getters / Setters ------------------------------------------
    public int    getId()       { return id; }
    public String getTitle()    { return title; }
    public String getCategory() { return category; }
    public float  getCost()     { return cost; }

    public void setTitle   (String title)    { this.title    = title;    }
    public void setCategory(String category) { this.category = category; }
    public void setCost    (float  cost)     { this.cost     = cost;     }

    // ---- Utilities --------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media m = (Media) o;
        return id == m.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("Media[id=%d, title=\"%s\", category=%s, cost=%.2f]",
                id, title, category, cost);
    }
}