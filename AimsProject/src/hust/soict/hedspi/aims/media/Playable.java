package src.hust.soict.hedspi.aims.media;


public interface Playable {
    /**
     * Plays the media item.
     * Returns a human-readable description of what is being played,
     * so the GUI can display it in a dialog.
     */
    String play();
}