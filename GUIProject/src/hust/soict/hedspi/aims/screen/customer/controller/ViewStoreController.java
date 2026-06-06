package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    @FXML
    private GridPane gridPane;

    private Store store;
    private Cart  cart;

    // ── Constructor ───────────────────────────────────────────────────────────

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart  = cart;
    }

    // ── JavaFX lifecycle ──────────────────────────────────────────────────────

    @FXML
    public void initialize() {
        final String ITEM_FXML_PATH =
                "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";

        int column = 0;
        int row    = 1;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(ITEM_FXML_PATH));

                ItemController itemController = new ItemController();
                loader.setController(itemController);

                AnchorPane anchorPane = loader.load();
                itemController.setData(store.getItemsInStore().get(i), cart);

                // Wrap at 3 columns
                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ── Event handlers ────────────────────────────────────────────────────────

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        final String CART_FXML_PATH =
                "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(CART_FXML_PATH));

            CartController cartController = new CartController(store, cart);
            loader.setController(cartController);

            Parent root  = loader.load();
            Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}