package src.hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import src.hust.soict.hedspi.aims.media.Book;
import src.hust.soict.hedspi.aims.store.Store;

/**
 * Màn hình thêm Book vào Store.
 * Kế thừa các field chung (title, category, cost) từ AddItemToStoreScreen.
 * Thêm các field riêng: author, coverType.
 */
public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private final JTextField tfAuthor    = new JTextField(20);
    private final JTextField tfCoverType = new JTextField(20);

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
    }

    @Override
    protected int addSpecificFields(JPanel form, GridBagConstraints gbc, int startRow) {
        int row = startRow;
        row = addRow(form, gbc, row, "Author:",     tfAuthor);
        row = addRow(form, gbc, row, "Cover Type:", tfCoverType);
        return row;
    }

    @Override
    protected void createMediaAndAdd() throws Exception {
        String title     = tfTitle.getText().trim();
        String category  = tfCategory.getText().trim();
        float  cost      = Float.parseFloat(tfCost.getText().trim());
        String author    = tfAuthor.getText().trim();
        String coverType = tfCoverType.getText().trim();

        Book book = new Book(title, category, cost, author, coverType);
        store.addMedia(book);
    }

    @Override
    protected void clearSpecificFields() {
        tfAuthor.setText("");
        tfCoverType.setText("");
    }
}