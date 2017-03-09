package workshop_wrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kond on 2017. 03. 08..
 * TODO: BoxLayout optimazation
 */
public class UIControls extends JPanel {

  private JTextField textfield1;
  private JLabel actualText, prevText;
  private JButton clearMemoryButton;

  public UIControls() {

    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    // JTextfield
    textfield1 = new JTextField("", 20);
    textfield1.addActionListener(new TextfieldActionListener());
    this.add(textfield1);
    Box.createRigidArea(new Dimension(0, 20));

    // JLabels
    actualText = new JLabel("Text: ");
    actualText.setHorizontalAlignment(JLabel.LEFT);
    prevText = new JLabel("Memory: ");
    prevText.setHorizontalAlignment(JLabel.LEFT);

    this.add(actualText);
    this.add(prevText);

    // JButton
    clearMemoryButton = new JButton("Clear Memory");
    clearMemoryButton.setHorizontalAlignment(JButton.LEFT);
    clearMemoryButton.addActionListener(new ClearMemoryButtonActionListener());
    this.add(clearMemoryButton);
    Box.createRigidArea(new Dimension(0, 20));

  }

  private class TextfieldActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      prevText.setText("Memory: " + actualText.getText().substring(6));
      actualText.setText("Text: " + textfield1.getText());
    }
  }

  private class ClearMemoryButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      prevText.setText("Memory: ");
    }
  }
}
