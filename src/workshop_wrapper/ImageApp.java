package workshop_wrapper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by kond on 2017. 03. 09..
 * TODO: Toolkit.getDefaultToolkit().createImage("attetszo.jpg") call didn't work for me
 */
public class ImageApp extends JFrame {

  private Image im;
  private BufferedImage image;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new ImageApp();
      }
    });
  }

  public ImageApp() {
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Image App");

    try {
      URL url = getClass().getResource("attetszo.jpg");
      image = ImageIO.read(new File(url.getPath()));
    } catch (IOException e) {
      e.printStackTrace();
    }

    ImagePanel imagePanel = new ImagePanel();

    im = Toolkit.getDefaultToolkit().createImage("attetszo.jpg");

    this.add(imagePanel);
    this.pack();
    this.setVisible(true);
  }

  private class ImagePanel extends JPanel {

    public ImagePanel() {
      setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    public void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      requestFocus();
      // Draw your image
      graphics.drawImage(image, 0, 0, this);
    }
  }
}
