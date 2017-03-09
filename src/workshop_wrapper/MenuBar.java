package workshop_wrapper;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by kond on 2017. 03. 09..
 */
public class MenuBar extends JMenuBar {
  public static final int FILE_MENU_POS = 0;
  public static final int SWING_MENU_POS = 1;
  public static final int EXTRA_MENU_POS = 2;
  public static final int EXIT_ITEM_POS = 0;
  public static final int HELLO_ITEM_POS = 0;
  public static final int COUNTER_ITEM_POS = 1;
  public static final int UI_ITEM_POS = 2;
  public static final int EVENT_COUNTER_ITEM_POS = 3;
  public static final int DRAW_ITEM_POS = 4;
  private JMenu fileMenu, swingMenu, extraMenu;
  private JMenuItem exitMenuItem, helloMenuItem, counterMenuItem, uiControlsMenuItem,
          eventCounterMenuItem, drawMenuItem;

  public MenuBar() {
    // Menus
    fileMenu = new JMenu("File");
    this.add(fileMenu);
    swingMenu = new JMenu("Swing");
    this.add(swingMenu);
    extraMenu = new JMenu("Extra");
    this.add(extraMenu);

    // Menu items
    exitMenuItem = new JMenuItem("Exit");
    fileMenu.add(exitMenuItem);

    helloMenuItem = new JMenuItem("Say hello to all the world");
    swingMenu.add(helloMenuItem);
    counterMenuItem = new JMenuItem("Counter app");
    swingMenu.add(counterMenuItem);
    uiControlsMenuItem = new JMenuItem("UI Controls");
    swingMenu.add(uiControlsMenuItem);
    eventCounterMenuItem = new JMenuItem("Event counter");
    swingMenu.add(eventCounterMenuItem);
    drawMenuItem = new JMenuItem("Draw to image");
    swingMenu.add(drawMenuItem);
  }
}
