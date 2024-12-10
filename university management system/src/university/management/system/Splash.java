package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {
        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        // Initialize and start the thread
        t = new Thread(this);
        t.start();

        // Set window properties
        setUndecorated(true); // Remove window borders
        setVisible(true);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        // Grow animation while staying in the center
        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            int width = i + 3 * x;
            int height = i + x / 2;

            int posX = (screenWidth - width) / 2; // Center X position
            int posY = (screenHeight - height) / 2; // Center Y position

            setLocation(posX, posY);
            setSize(width, height);

            try {
                Thread.sleep(10); // Control animation speed
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        try {
            Thread.sleep(7000); // Splash screen duration
            setVisible(false); // Hide splash screen
            new Login(); // Open login screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
