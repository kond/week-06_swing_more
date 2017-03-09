package menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by kond on 2017. 03. 09..
 */
public class WrapperApp extends JFrame implements ActionListener {

  private JMenuBar menuBar;
  private JMenu menu;
  private JMenuItem menuItem;

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

    // Menu
    menuBar = new JMenuBar();

    menu = new JMenu("File");
    menuBar.add(menu);

    menuItem = new JMenuItem("Exit");
    ListenMouseEvent lMouseEvent = new ListenMouseEvent();
    menuItem.addMouseListener(lMouseEvent);
    menu.add(menuItem);

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
}
