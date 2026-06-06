package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML private Label  lblTitle;
    @FXML private Label  lblCost;
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;

    private Media media;
    private Cart  cart;

    /**
     * Called by ViewStoreController after the FXML is loaded.
     * Sets the media data and the cart reference.
     */
    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart  = cart;

        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked() {
        if (cart != null && media != null) {
            cart.addMedia(media);
            showInfo("Added \"" + media.getTitle() + "\" to cart.");
        }
    }

    @FXML
    void btnPlayClicked() {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                showError("Cannot play media: " + e.getMessage());
            }
        }
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    private void showInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Playback Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}