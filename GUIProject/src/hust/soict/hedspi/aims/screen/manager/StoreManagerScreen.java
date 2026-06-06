package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {

    private final Store store;

    // ---- Constructor -----------------------------------------------
    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),  BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(createCenter());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cp.add(scroll, BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ---- NORTH: menu bar + header ----------------------------------
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // View Store – refresh
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });
        menu.add(viewStore);

        // Update Store sub-menu
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store);
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    // ---- CENTER: lưới media ----------------------------------------
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 2, 2)); // số hàng động, 3 cột

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            center.add(new MediaStore(media));
        }
        return center;
    }

    // ---- main: seed data + khởi chạy -------------------------------
    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc(
                1, "Harry Potter and the Philosopher's Stone (2001)", "Fantasy", 3.0f, 152, "Chris Columbus"));
        store.addMedia(new DigitalVideoDisc(
                2, "Harry Potter and the Chamber of Secrets (2002)", "Fantasy", 3.5f, 161, "Chris Columbus"));
        store.addMedia(new DigitalVideoDisc(
                3, "Harry Potter and the Prisoner of Azkaban (2004)", "Fantasy", 5.0f, 142, "Alfonso Cuarón"));
        store.addMedia(new DigitalVideoDisc(
                4, "Harry Potter and the Goblet of Fire (2005)", "Fantasy", 4.5f, 157, "Mike Newell"));

        store.addMedia(new CompactDisc(
                5, "Fetch the Bolt Cutters", "Alternative", 10.39f, "", "Fiona Apple"));
        store.addMedia(new CompactDisc(
                6, "Future Nostalgia", "Pop", 9.6f, "", "Dua Lipa"));

        store.addMedia(new Book(
                7, "The Hunger Games", "Dystopian Fiction", 5.5f));
        store.addMedia(new Book(
                8, "Catching Fire", "Dystopian Fiction", 4.9f));
        store.addMedia(new Book(
                9, "Mockingjay", "Dystopian Fiction", 5.1f));

        SwingUtilities.invokeLater(() -> new StoreManagerScreen(store));
    }
}