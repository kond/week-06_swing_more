package workshop_wrapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kond on 2017. 03. 08..
 */
public class Counter extends JPanel {

  private JButton countButton, resetButton;
  private JLabel countLabel;
  private int pressCount = 0;

  public Counter() {

    // JButtons
    countButton = new JButton("Press me!");
    countButton.addActionListener(new CountButtonActionListener());
    this.add(countButton);

    resetButton = new JButton("Reset");
    resetButton.addActionListener(new ResetButtonActionListener());
    this.add(resetButton);

    // JLabel
    countLabel = new JLabel("Pressed: 0");
    this.add(countLabel);

    this.setVisible(true);
  }

  private void updateCounter() {
    countLabel.setText("Pressed: " + pressCount);
  }

  private class CountButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      pressCount++;
      updateCounter();
    }
  }

  private class ResetButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      pressCount = 0;
      updateCounter();
    }
  }
}
