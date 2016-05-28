package sample;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Point extends Rectangle   // Point - клетка
{
    private static final long serialVersionUID = 1L;

    public int x;               // Координаты клетки
    public int y;               //
    final static int size = 10;      // Размер клетки в пикселах

    Point(int x, int y)            // Конструктор
    {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g, Color color)   // Рисует клетку
    {
        g.setColor(color);
        g.fillRect(x*size,y*size,size,size);
    }
}
