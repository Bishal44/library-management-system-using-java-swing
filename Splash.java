

//import the packages for using the classes in them into the program
import javax.swing.*;
import java.awt.*;

public class Splash {
    // A simple little method to show a title screen in the
    // center of the screen for a given amount of time.
    public void showSplash(int duration) {
        JWindow splash = new JWindow();
        JPanel content = (JPanel) splash.getContentPane();

        // set the window's bounds, centering the window
        int width = 354;
        int height = 268;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        splash.setBounds(x, y, width, height);

        // build the splash screen
        JLabel label = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images/splash.JPG")));
        JLabel copyrt = new JLabel("", JLabel.CENTER);
        copyrt.setFont(new Font("Tahoma", Font.BOLD, 10));
        //copyrt.setBorder(BorderFactory.createEtchedBorder());
        content.setBackground(Color.LIGHT_GRAY);
        //content.setBackground(new Color(232, 232, 228));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // display it
        splash.setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }

        splash.setVisible(false);
    }
}
