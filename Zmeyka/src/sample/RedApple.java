package sample;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Random;

public class RedApple extends Component{
    public Point location;
    boolean eatable;
    Snake snake;
    RedApple(){
        Random rnd = new Random();
        location = new Point (rnd.nextInt(55)+2, rnd.nextInt(51)+6);
        eatable = false;
    }
    RedApple(int x, int y){
        this.location = new Point(x,y);
    }

    public void paint(Graphics g)  {
        location.paint(g, Color.RED);
//           System.out.println(location.x+"-"+location.y);
    }
}