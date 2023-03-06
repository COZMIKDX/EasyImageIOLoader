# EasyImageIOLoader
This is a simple Java class I made for loading an image resource from the project's designated resource folder.
This way I don't need to worry about file paths and have a clean (at least visually) way to load texture files.

## Usage
Create a new instance of the EasyImageIOLoader class and call the loadImage() method.
```java
public BufferedImage loadImage(String filename)
```
Your argument should be a file path such as:
```
/images/image1.png
```
The path begins in the project's resource folder which you may have designated yourself or through your IDE.

## Example
Here is an example from an old project I made this for.
```java
View(Controller controller, Model model)
    {
        this.controller = controller;
        this.model = model;
        model.view = this;

        this.setPreferredSize(new Dimension(1920,1080));

        if (bg == null)
        {
            System.out.println("loading bg");
            // Changed image loading method slightly.
            // Instead of a relative file path, which only works for launching from
            // the same folder as the class file or jar, I use a class loader to load
            // the files as an input stream. Then I give that to Image.IO.
            ImageLoader imageLoader = new ImageLoader();
            bg = imageLoader.loadImage("assets/LOGINSCREEN.png");
        }
    }
```
