package src.hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import src.hust.soict.hedspi.aims.store.Store;

/**
 * Abstract parent cho AddBookToStoreScreen, AddCompactDiscToStoreScreen,
 * AddDigitalVideoDiscToStoreScreen.
 *
 * Cung cấp:
 *  - Menu bar giống StoreManagerScreen (Options → View Store / Update Store)
 *  - Common fields: title, category, cost
 *  - Nút "Add to Store" và xử lý sự kiện
 *  - Abstract hooks để subclass thêm fields và tạo đối tượng
 */
public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;

    // --- Common input fields ---
    protected JTextField tfTitle    = new JTextField(20);
    protected JTextField tfCategory = new JTextField(20);
    protected JTextField tfCost     = new JTextField(20);

    // ---- Constructor -----------------------------------------------
    protected AddItemToStoreScreen(Store store, String screenTitle) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),  BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle(screenTitle);
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // ---- North: menu bar -------------------------------------------
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> { dispose(); new AddBookToStoreScreen(store); });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> { dispose(); new AddCompactDiscToStoreScreen(store); });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> { dispose(); new AddDigitalVideoDiscToStoreScreen(store); });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    // ---- Center: form ----------------------------------------------
    private JPanel createCenter() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets  = new Insets(6, 10, 6, 10);
        gbc.anchor  = GridBagConstraints.WEST;
        gbc.fill    = GridBagConstraints.HORIZONTAL;

        int row = 0;
        row = addRow(form, gbc, row, "Title:",    tfTitle);
        row = addRow(form, gbc, row, "Category:", tfCategory);
        row = addRow(form, gbc, row, "Cost ($):", tfCost);
        row = addSpecificFields(form, gbc, row);   // hook cho subclass

        // Nút "Add to Store"
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> {
            try {
                createMediaAndAdd();
                JOptionPane.showMessageDialog(this,
                        "Item added successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid numeric values for Cost/Length.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        form.add(btnAdd, gbc);

        return form;
    }

    /** Thêm một hàng label + field vào form, trả về chỉ số hàng tiếp theo. */
    protected int addRow(JPanel panel, GridBagConstraints gbc,
                         int row, String labelText, JComponent field) {
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel(labelText), gbc);
        gbc.gridx = 1; gbc.gridy = row;
        panel.add(field, gbc);
        return row + 1;
    }

    // ---- Abstract hooks --------------------------------------------

    /** Subclass thêm các field riêng, trả về chỉ số hàng tiếp theo. */
    protected abstract int addSpecificFields(JPanel form,
                                             GridBagConstraints gbc, int startRow);

    /** Subclass đọc field, tạo đối tượng Media, gọi store.addMedia(). */
    protected abstract void createMediaAndAdd() throws Exception;

    /** Reset toàn bộ field sau khi add thành công. */
    protected void clearFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        clearSpecificFields();
    }

    /** Subclass reset các field riêng của mình. */
    protected abstract void clearSpecificFields();
}