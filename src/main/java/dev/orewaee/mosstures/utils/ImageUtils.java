package dev.orewaee.mosstures.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtils {
    public static BufferedImage resize(BufferedImage original, int width, int height) throws IOException {
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resized.createGraphics();

        g2d.drawImage(original, 0, 0, width, height, null);
        g2d.dispose();

        return resized;
    }
}
