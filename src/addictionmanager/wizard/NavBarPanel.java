/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.wizard;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Deminem
 */
public class NavBarPanel extends JPanel {

  private Image img;

  public NavBarPanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public NavBarPanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}
