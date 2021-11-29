import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Design {
    public static final Color dark1 = new Color(43, 43, 43);
    public static final Color yellow2 = new Color(203, 120, 50);
    public static final Color yellow1 = new Color(253, 196, 99);
    public static final BevelBorder border = new BevelBorder(0, yellow1, yellow2);
    public static final Font font = new Font("Times New Roman", Font.BOLD, 18);

    public static void applyDesign(JComponent c) {
        if (c.getClass() != JLabel.class) {
            c.setBorder(border);
        }
        if (c.getClass() == JTextField.class||c.getClass() == JTextArea.class) {
            ((JTextField) c).setCaretColor(yellow2);
        }

        c.setBackground(dark1);
        c.setFont(font);
        c.setVisible(true);
        c.setForeground(yellow1);



    }

    public static void applyDesign(Container cp, JFrame f) {
        cp.setBackground(dark1);
        cp.setFont(font);
        cp.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(700, 700);
        f.setFont(font);
        f.setLayout(null);
        f.setResizable(true);
    }
}
