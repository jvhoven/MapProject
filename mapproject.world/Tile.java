package mapproject.world;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;

public class Tile {
    
    public int width = 10;
    public int height = 10;
    
    BufferedImage texture;

    Tile(String texture, int width, int height) {
        this.width = width;
        this.height = height;
          
        try{
            URI tileUrl = getClass().getResource(texture).toURI();
            this.texture = ImageIO.read(new File(tileUrl));
        } catch (IOException | URISyntaxException e){
            e.printStackTrace();
        }
    }
    
    public BufferedImage getSource(){
        return (BufferedImage) this.texture;
    }
}
