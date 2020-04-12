import javax.swing.*;
import java.awt.*;

public class MainSweeper extends JFrame {
    private JPanel panel;
    private final int COLS = 10;
    private final int ROWS = 10;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new MainSweeper();
    }

    private MainSweeper() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < 10; i++) {
                    g.drawImage(getImage("closed"), 0, i*IMAGE_SIZE, this);
                    for (int j = 0; j < 10; j++) {
                        g.drawImage(getImage("closed"), i*IMAGE_SIZE, j*IMAGE_SIZE, this);
                    }
                }
            }
        };
        panel.setPreferredSize(new Dimension(
                COLS*IMAGE_SIZE, ROWS*IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAVA SWEEPER");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private Image getImage(String name) {
        String fileName = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }
}
