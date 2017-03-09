package eventcounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by kond on 2017. 03. 09..
 */
public class EventCounter {

  JTextField inputTextField;
  JLabel mouseEventsLabel, keyEventsLabel, windowEventsLabel;
  int mouseEvents, keyEvents, windowEvents;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new EventCounter();
      }
    });
  }

  public EventCounter() {
    // Frame
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setTitle("Event Counter");


    // Panel
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 1));

    inputTextField = new JTextField(30);
    ListenForKeys lForKeys = new ListenForKeys();
    inputTextField.addKeyListener(lForKeys);
    panel.add(inputTextField);

    keyEventsLabel = new JLabel("Key events: 0");
    panel.add(keyEventsLabel);

    mouseEventsLabel = new JLabel("Mouse events: 0");
    panel.add(mouseEventsLabel);

    windowEventsLabel = new JLabel("Window events: 0");
    panel.add(windowEventsLabel);

    // Mouse listeners
    ListenForMouse lForMouse = new ListenForMouse();
    frame.addMouseListener(lForMouse);

    // Window Listener
    ListenForWindow lForWindow = new ListenForWindow();
    frame.addWindowListener(lForWindow);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  private void updateLabel(JLabel label, int value) {
    String prevText = label.getText();
    prevText = prevText.substring(0, prevText.indexOf(":") + 2);
    label.setText(prevText + value);
  }


  private class ListenForKeys implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      keyEvents++;
      updateLabel(keyEventsLabel, keyEvents);
    }

    @Override
    public void keyReleased(KeyEvent e) {
      keyEvents++;
      updateLabel(keyEventsLabel, keyEvents);
    }
  }

  private class ListenForMouse implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
      mouseEvents++;
      updateLabel(mouseEventsLabel, mouseEvents);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
  }

  private class ListenForWindow implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
      windowEvents++;
      updateLabel(windowEventsLabel, windowEvents);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
      windowEvents++;
      updateLabel(windowEventsLabel, windowEvents);
    }

    @Override
    public void windowActivated(WindowEvent e) {
      windowEvents++;
      updateLabel(windowEventsLabel, windowEvents);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
      windowEvents++;
      updateLabel(windowEventsLabel, windowEvents);
    }
  }
}
