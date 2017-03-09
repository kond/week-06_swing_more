package draw_to_image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * Created by kond on 2017. 03. 09..
 */
public class WrapperApp extends JFrame implements ActionListener {

  private JMenuBar menuBar;
  private JMenu fileMenu, swingMenu, extraMenu;
  private JMenuItem exitMenuItem;
  private BufferedImage image;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new WrapperApp();
      }
    });
  }

  public WrapperApp() {
    // Frame
    this.setSize(500, 500);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Menu bar
    menuBar = new JMenuBar();

    // Menus
    fileMenu = new JMenu("File");
    menuBar.add(fileMenu);
    swingMenu = new JMenu("Swing");
    menuBar.add(swingMenu);
    extraMenu = new JMenu("Extra");
    menuBar.add(extraMenu);

    // Menu items
    exitMenuItem = new JMenuItem("Exit");
    ListenMouseEvent lMouseEvent = new ListenMouseEvent();
    exitMenuItem.addMouseListener(lMouseEvent);
    fileMenu.add(exitMenuItem);

    // Load image
    try {
      URL url = getClass().getResource("attetszo.jpg");
      image = ImageIO.read(new File(url.getPath()));
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Image panel
    ImagePanel imagePanel = new ImagePanel();
    this.add(imagePanel);

    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  private class ListenMouseEvent implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
      System.exit(0);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
  }

  private class ImagePanel extends JPanel {

    @Override
    public void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      requestFocus();
      graphics.drawImage(image, 7, 25, this);

      graphics.setColor(Color.BLACK);
      graphics.setFont(new Font("Ariel", Font.BOLD, 20));
      graphics.drawString("WHAAAAT??!!!!", 7, 30);

      graphics.setColor(new Color(200, 200, 100));
      graphics.drawOval(270, 45, 70, 120);

      graphics.setColor(Color.BLUE);
      graphics.fillRect(280, 100, 50, 10);

      graphics.setColor(Color.PINK);
      graphics.fillOval(230, 210, 15, 15);
      graphics.fillOval(290, 210, 15, 15);
    }

  }
}
