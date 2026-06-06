package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    // ── FXML fields ───────────────────────────────────────────────────────────

    @FXML private TableView<Media>            tblMedia;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String>  colMediaTitle;
    @FXML private TableColumn<Media, String>  colMediaCategory;
    @FXML private TableColumn<Media, Float>   colMediaCost;

    @FXML private TextField   tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;

    @FXML private Label costLabel;

    // ── State ─────────────────────────────────────────────────────────────────

    private Store store;
    private Cart  cart;
    private FilteredList<Media> filteredList;

    // ── Constructor ───────────────────────────────────────────────────────────

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart  = cart;
    }

    // ── JavaFX lifecycle ──────────────────────────────────────────────────────

    @FXML
    public void initialize() {
        // 1. Wire up column cell-value factories
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<>("cost"));

        // 2. Wrap the cart's ObservableList in a FilteredList
        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        // 3. Update total cost label
        updateCostLabel();

        // 4. Hide Play/Remove buttons until a row is selected
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // 5. ChangeListener on table selection
        tblMedia.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue, Media newValue) {
                        updateButtonBar(newValue);
                    }
                });

        // 6. ChangeListener on filter text field
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    // ── Helper: update button bar visibility ──────────────────────────────────

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    // ── Helper: filter logic ─────────────────────────────────────────────────

    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            filteredList.setPredicate(m -> true);
            return;
        }

        if (radioBtnFilterId.isSelected()) {
            // Filter by ID (numeric match)
            filteredList.setPredicate(m -> {
                try {
                    int id = Integer.parseInt(filterText.trim());
                    return m.getId() == id;
                } catch (NumberFormatException e) {
                    return false;
                }
            });
        } else {
            // Filter by Title (case-insensitive contains)
            String lower = filterText.toLowerCase();
            filteredList.setPredicate(
                    m -> m.getTitle().toLowerCase().contains(lower));
        }
    }

    // ── Helper: refresh total cost label ─────────────────────────────────────

    private void updateCostLabel() {
        costLabel.setText(String.format("%.1f $", cart.calculateTotalCost()));
    }

    // ── Event handlers ────────────────────────────────────────────────────────

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                showError("Cannot play media: " + e.getMessage());
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateCostLabel();
            updateButtonBar(null);
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed!\nTotal: "
                + cart.calculateTotalCost() + " $");
        alert.showAndWait();
        cart.emptyCart();
        updateCostLabel();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        final String STORE_FXML_PATH =
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(STORE_FXML_PATH));

            ViewStoreController storeController =
                    new ViewStoreController(store, cart);
            loader.setController(storeController);

            Parent root  = loader.load();
            Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ── Helper: error dialog ─────────────────────────────────────────────────

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Playback Error");
        alert.setHeaderText("Cannot play media");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}