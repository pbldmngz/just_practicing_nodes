//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Libre;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Sreenshoots_delays {
    public static void main(String[] args) {
        Rectangle rec = argFrame.getBounds();
    BufferedImage bufferedImage = new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
    argFrame.paint(bufferedImage.getGraphics());

    try {
        // Create temp file
        File temp = File.createTempFile("screenshot", ".png");

        // Use the ImageIO API to write the bufferedImage to a temporary file
        ImageIO.write(bufferedImage, "png", temp);

        // Delete temp file when program exits
        temp.deleteOnExit();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    }
}
