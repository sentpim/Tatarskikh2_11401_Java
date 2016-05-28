package sample;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Point extends Rectangle   // Point - ������
{
    private static final long serialVersionUID = 1L;

    public int x;               // ���������� ������
    public int y;               //
    final static int size = 10;      // ������ ������ � ��������

    Point(int x, int y)            // �����������
    {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g, Color color)   // ������ ������
    {
        g.setColor(color);
        g.fillRect(x*size,y*size,size,size);
    }
}
