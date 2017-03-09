package workshop_wrapper;

import javax.swing.*;

/**
 * Created by kond on 2017. 03. 08..
 */
public class HelloWorld extends JFrame {

  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new HelloWorld();
      }
    });

  }

  public HelloWorld() {
    // JFrame
    this.setSize(400, 400);
    this.setLocationRelativeTo(null);
    this.setTitle("Hello World");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // JPanel
    JPanel panel = new JPanel();

    // JLabel
    JLabel label1 = new JLabel("HelloWorld");
    label1.setVisible(true);
    panel.add(label1);

    this.add(panel);

    this.setVisible(true);
  }

}
