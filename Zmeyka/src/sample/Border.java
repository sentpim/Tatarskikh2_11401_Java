package sample;

import java.awt.Color;
import java.awt.Graphics;

public class Border {
    Point lineOne;
    Point lineTwo;

    Border() {
        lineOne = new Point(1, 5);
        lineTwo = new Point(58, 58);
    }

    public void paint(Graphics g) {
        for (int i = 1; i < 59; i++) {
            lineOne = new Point (i,5);
            lineOne.paint(g, Color.lightGray);
            lineTwo = new Point (i,58);
            lineTwo.paint(g, Color.lightGray);
        }
        for (int i = 5; i < 59; i++) {
            lineOne = new Point (1,i);
            lineOne.paint(g, Color.lightGray);
            lineTwo = new Point (58,i);
            lineTwo.paint(g, Color.lightGray);
        }
    }
}
