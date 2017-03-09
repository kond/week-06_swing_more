package workshop_wrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by kond on 2017. 03. 09..
 */
public class EventCounter extends JPanel {

  JTextField inputTextField;
  JLabel mouseEventsLabel, keyEventsLabel, windowEventsLabel;
  int mouseEvents, keyEvents, windowEvents;

  public EventCounter() {
    //JFrame frame = (JFrame) SwingUtilities.windowForComponent(this);

    this.setLayout(new GridLayout(4, 1));

    inputTextField = new JTextField(30);
    ListenForKeys lForKeys = new ListenForKeys();
    inputTextField.addKeyListener(lForKeys);
    this.add(inputTextField);

    keyEventsLabel = new JLabel("Key events: 0");
    this.add(keyEventsLabel);

    mouseEventsLabel = new JLabel("Mouse events: 0");
    this.add(mouseEventsLabel);

    windowEventsLabel = new JLabel("Window events: 0");
    this.add(windowEventsLabel);

    // Mouse listeners
    ListenForMouse lForMouse = new ListenForMouse();
    //frame.addMouseListener(lForMouse);

    // Window Listener
    ListenForWindow lForWindow = new ListenForWindow();
    //frame.addWindowListener(lForWindow);
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
