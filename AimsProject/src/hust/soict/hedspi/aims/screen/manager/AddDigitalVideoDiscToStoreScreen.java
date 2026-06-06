package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import src.hust.soict.hedspi.aims.store.Store;

/**
 * Màn hình thêm DigitalVideoDisc vào Store.
 * Kế thừa các field chung (title, category, cost) từ AddItemToStoreScreen.
 * Thêm các field riêng: director, length.
 */
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private final JTextField tfDirector = new JTextField(20);
    private final JTextField tfLength   = new JTextField(20);

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add Digital Video Disc to Store");
    }

    @Override
    protected int addSpecificFields(JPanel form, GridBagConstraints gbc, int startRow) {
        int row = startRow;
        row = addRow(form, gbc, row, "Director:",     tfDirector);
        row = addRow(form, gbc, row, "Length (min):", tfLength);
        return row;
    }

    @Override
    protected void createMediaAndAdd() throws Exception {
        String title    = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        float  cost     = Float.parseFloat(tfCost.getText().trim());
        String director = tfDirector.getText().trim();
        int    length   = Integer.parseInt(tfLength.getText().trim());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, director, length);
        store.addMedia(dvd);
    }

    @Override
    protected void clearSpecificFields() {
        tfDirector.setText("");
        tfLength.setText("");
    }
}