package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

/**
 * Màn hình thêm CompactDisc vào Store.
 * Kế thừa các field chung (title, category, cost) từ AddItemToStoreScreen.
 * Thêm các field riêng: artist, length.
 */
public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private final JTextField tfArtist = new JTextField(20);
    private final JTextField tfLength = new JTextField(20);

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add Compact Disc to Store");
    }

    @Override
    protected int addSpecificFields(JPanel form, GridBagConstraints gbc, int startRow) {
        int row = startRow;
        row = addRow(form, gbc, row, "Artist:",       tfArtist);
        row = addRow(form, gbc, row, "Length (min):", tfLength);
        return row;
    }

    @Override
    protected void createMediaAndAdd() throws Exception {
        String title    = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        float  cost     = Float.parseFloat(tfCost.getText().trim());
        String artist   = tfArtist.getText().trim();
        int    length   = Integer.parseInt(tfLength.getText().trim());

        CompactDisc cd = new CompactDisc(title, category, cost, artist, length);
        store.addMedia(cd);
    }

    @Override
    protected void clearSpecificFields() {
        tfArtist.setText("");
        tfLength.setText("");
    }
}