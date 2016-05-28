package sample;

import java.awt.*;

public class Snake extends Component // ������
{
    private static final long serialVersionUID = 1L;

    List part; // �����(������), �� ������� ������� ������
    Direction direction; // �����������
    boolean alive; // ����
    boolean ate; // ����� ������
    RedApple apple;

    Snake() // �����������
    {
        direction = new Direction();
        direction.state = Direction.RIGHT;// ��������� ����������� ������ -
        // �����
        Point point;
        part = new List();
        point = new Point(3, 6);
        part.add(point);
        point = new Point(4, 6);
        part.add(point);
        point = new Point(5, 6);
        part.add(point);
        point = new Point(6, 6);
        part.add(point);
        point = new Point(7, 6);
        part.add(point);
        alive = true; // ������ ����
        ate = false; // ���� ������ �� �����
    }

    public void turnLeft() // ��������� ������
    {
        direction.changeToLeft();
    }

    public void turnRight() // ��������� �������
    {
        direction.changeToRight();
    }

    public void turnUp() // ��������� �����
    {
        direction.changeToUp();
    }

    public void turnDown() // ��������� ����
    {
        direction.changeToDown();
    }

    public void step() // ������� ���
    {
        if (!ate()) // ���� ������ ������ �� �����
        {
            part.deleteFirst(); // ������� �����
        } // ����� �� �������, ����� ������� ����� ������ ������������� �� 1

        Point point = (Point) part.Last(); // ������ ������
        Point New;// = new Point(0, 0); // ����� ������
        if (point != null) // ���� ������ ���� (������)
        {
            New = new Point(point.x, point.y); // ������� ������ � ������������
            // ������

            System.out.println("direction = " + direction.state);

            switch (direction.state) // ������� �����������
            {
                case Direction.RIGHT:
                    New.x += 1; // ���� ������� ->
//                System.out.println("right");
                    break;
                case Direction.DOWN:
                    New.y += 1; // ���� ���� \/
//                System.out.println("down");
                    break;
                case Direction.LEFT:
                    New.x -= 1; // ���� ����� <-
//                System.out.println("left");
                    break;
                case Direction.UP:
                    New.y -= 1; // ���� ����� /\
//                System.out.println("up");
                    break;
                default:
//                System.out.println("-------------");
            }
//            System.out.println("���");
            part.add(New); // ����� ������ (����� ����)
            alive = isAlive(); // ���������, ���� �� ������
            repaint();
            MainClass.game.repaint();
//            System.out.println(point.x+"+"+point.y);
        }
    }

    boolean ate() // ���������, ����� �� ���� ������
    {
        return ate;
    }

    boolean isAlive() // ���������, ���� �� ������. � � �� ����� �� ��� ��
    // ������� ���� � �� ����� �� ����
    {
        return alive;
    }

    public void paint(Graphics g) // ������ ������
    {
        part.toFirst();
        Point point = (Point) part.current();
        point.paint(g, Color.DARK_GRAY);

        while (part.hasNext()) {
            part.next();
            point = (Point) part.current();
            point.paint(g, Color.DARK_GRAY);
            g.fillRect(point.x * Point.size, point.y * Point.size, Point.size,
                    Point.size);
        }
    }

}
