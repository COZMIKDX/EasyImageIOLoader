package com.cozmikdx.easyimageioloader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class EasyImageIOLoader {
    // Get a file from your resource folder.
    private InputStream getResourceStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // Make sure the inputStream actually has something.
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    // The user calls this function.
    // The string path you provide must be entered as if your resource folder is the current directory.
    // Example: Your resource folder contains a folder named images with an image
    // named image1.png.
    // The path you enter would be "images/image1.png"
    public BufferedImage loadImage(String filename)
    {
        BufferedImage image = null;
        try
        {
            EasyImageIOLoader imageloader = new EasyImageIOLoader();
            InputStream is = imageloader.getResourceStream(filename);
            image = ImageIO.read(is);
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            System.exit(1);
        }

        return image;
    }
}