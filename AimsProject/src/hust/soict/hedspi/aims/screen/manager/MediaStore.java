package src.hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import src.hust.soict.hedspi.aims.media.Media;
import src.hust.soict.hedspi.aims.media.Playable;

/**
 * JPanel cell đại diện cho một Media item trong Store screen.
 * Nếu Media implements Playable thì hiển thị nút "Play",
 * click vào sẽ mở JDialog.
 */
public class MediaStore extends JPanel {

    private final Media media;

    public MediaStore(Media media) {
        this.media = media;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tiêu đề
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Giá
        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Container cho nút (căn giữa)
        JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnContainer.setOpaque(false);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> showPlayDialog());
            btnContainer.add(btnPlay);
        }

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(Box.createVerticalGlue());
        add(btnContainer);

        setBorder(new LineBorder(Color.BLACK));
    }

    private void showPlayDialog() {
        String message = ((Playable) media).play();

        JDialog dialog = new JDialog();
        dialog.setTitle("Now Playing");
        dialog.setSize(420, 140);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 14));
        dialog.add(label, BorderLayout.CENTER);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> dialog.dispose());
        JPanel south = new JPanel();
        south.add(btnClose);
        dialog.add(south, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}