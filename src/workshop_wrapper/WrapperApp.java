package workshop_wrapper;

import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * Created by kond on 2017. 03. 09..
 */
public class WrapperApp {

  private JFrame frame;
  private MenuBar menuBar;

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
    frame = new JFrame();
    frame.setSize(500, 500);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    menuBar = new MenuBar();
    ListenMenuItemClick menuItemClick = new ListenMenuItemClick();
    for(int i=0; i<menuBar.getMenuCount(); i++) {
      for(int j=0; j<menuBar.getMenu(i).getItemCount(); j++) {
        menuBar.getMenu(i).getItem(j).addMouseListener(menuItemClick);
      }
    }

    frame.setJMenuBar(menuBar);
    frame.setVisible(true);
  }

  private class ListenMenuItemClick implements MouseListener {

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
      frame.getContentPane().removeAll();
      if(e.getSource() == menuBar.getMenu(MenuBar.FILE_MENU_POS). // If exit
              getItem(MenuBar.EXIT_ITEM_POS)) {
        System.exit(0);
      } else if(e.getSource() == menuBar.getMenu(MenuBar.SWING_MENU_POS). // If Hello World
              getItem(MenuBar.HELLO_ITEM_POS)) {
        frame.getContentPane().add(new SayHelloToAllTheWorld());
      } else if(e.getSource() == menuBar.getMenu(MenuBar.SWING_MENU_POS).
              getItem(MenuBar.COUNTER_ITEM_POS)) {
        frame.getContentPane().add(new Counter());
      } else if(e.getSource() == menuBar.getMenu(MenuBar.SWING_MENU_POS).
              getItem(MenuBar.UI_ITEM_POS)) {
        frame.getContentPane().add(new UIControls());
      }
      else {
        System.out.println("Menu click happened");
        System.out.println(e.getSource().toString());
      }
      frame.setVisible(true);
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }
  }
}
