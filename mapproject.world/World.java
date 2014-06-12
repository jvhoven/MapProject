package mapproject.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mapproject.MapProject;

public class World {
    
    public final int TILE_WIDTH = 50;
    public final int TILE_HEIGHT = 50;
    
    Tile GRASS;
    Tile ROCKS;
    
    BufferedImage tile;
    MapProject game;
   
    public World(MapProject game){
       this.game = game;
       
       GRASS = new Tile("grass.png", 50, 50);
       ROCKS = new Tile("rock.png", 50, 50);
    }
    
    public void render(Graphics g){
       
        int nroftiles = 0;
        
        // Base layer with grass
        for (int x=0; x<= game.WIDTH / ROCKS.width; x++)
        {
            for (int y=0; y<= game.HEIGHT / ROCKS.height ; y++)
            {
                g.drawImage(ROCKS.getSource(), x * ROCKS.width, y * ROCKS.height, game);
                nroftiles++;
            }
        }
        
        System.out.println(nroftiles);
    }
}
