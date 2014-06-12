package mapproject;

import mapproject.world.World;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MapProject extends JPanel {
    
    public final static int WIDTH = 1280;
    public final static int HEIGHT = 900;
    
    World world = new World(this);
    Graphics buffer;
    Image offscreen;
    
    public MapProject(){
        
        offscreen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        buffer = offscreen.getGraphics();
        world.render(buffer);
        setFocusable(true);
    }
    
    public void paint(Graphics g)
    {
        //world.render(g);
       g.drawImage(offscreen,0,0,this); 
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        JFrame frame = new JFrame("Map");
        MapProject game = new MapProject();
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            game.repaint();
            Thread.sleep(20);
        }
    }

}
