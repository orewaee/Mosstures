package dev.orewaee.mosstures.services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import dev.orewaee.mosstures.exceptions.TextureNotFoundException;
import dev.orewaee.mosstures.utils.ImageUtils;

@Service
public class TextureService {
    public byte[] getTexture(String name) throws IOException {
        File file = new File("./textures/" + name + ".png");

        if (!file.exists()) throw new TextureNotFoundException("Texture not found");

        BufferedImage image = ImageIO.read(file);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", stream);

        return stream.toByteArray();
    }

    public byte[] getTexture(String name, Integer size) throws IOException {
        File file = new File("./textures/" + name + ".png");

        if (!file.exists()) throw new TextureNotFoundException("Texture not found");

        BufferedImage original = ImageIO.read(file);
        BufferedImage resized = ImageUtils.resize(original, size, size);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(resized, "png", stream);

        return stream.toByteArray();
    }
}
