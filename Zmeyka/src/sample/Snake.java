package sample;

import java.awt.*;

public class Snake extends Component // Змейка
{
    private static final long serialVersionUID = 1L;

    List part; // Части(клетки), из которых состоит змейка
    Direction direction; // Направление
    boolean alive; // Жива
    boolean ate; // Сьела яблоко
    RedApple apple;

    Snake() // Конструктор
    {
        direction = new Direction();
        direction.state = Direction.RIGHT;// Начальное направление змейки -
        // влево
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
        alive = true; // Змейка жива
        ate = false; // Пока ничего не съела
    }

    public void turnLeft() // Повернуть налево
    {
        direction.changeToLeft();
    }

    public void turnRight() // Повернуть направо
    {
        direction.changeToRight();
    }

    public void turnUp() // Повернуть вверх
    {
        direction.changeToUp();
    }

    public void turnDown() // Повернуть вниз
    {
        direction.changeToDown();
    }

    public void step() // Сделать шаг
    {
        if (!ate()) // Если змейка ничего не съела
        {
            part.deleteFirst(); // Стирает хвост
        } // Иначе не стирает, таким образом длина змейки увеличивается на 1

        Point point = (Point) part.Last(); // Голова змейки
        Point New;// = new Point(0, 0); // Новая голова
        if (point != null) // Если змейка есть (голова)
        {
            New = new Point(point.x, point.y); // Создать клетку с координатами
            // головы

            System.out.println("direction = " + direction.state);

            switch (direction.state) // Выбрать направление
            {
                case Direction.RIGHT:
                    New.x += 1; // Если направо ->
//                System.out.println("right");
                    break;
                case Direction.DOWN:
                    New.y += 1; // Если вниз \/
//                System.out.println("down");
                    break;
                case Direction.LEFT:
                    New.x -= 1; // Если влево <-
//                System.out.println("left");
                    break;
                case Direction.UP:
                    New.y -= 1; // Если вверх /\
//                System.out.println("up");
                    break;
                default:
//                System.out.println("-------------");
            }
//            System.out.println("шаг");
            part.add(New); // Новая голова (после шага)
            alive = isAlive(); // Проверить, жива ли змейка
            repaint();
            MainClass.game.repaint();
//            System.out.println(point.x+"+"+point.y);
        }
    }

    boolean ate() // Проверяет, сьела ли змея яблоко
    {
        return ate;
    }

    boolean isAlive() // Проверяет, жива ли змейка. Т е Не вышла ли она за
    // границы поля и не съела ли себя
    {
        return alive;
    }

    public void paint(Graphics g) // Рисует змейку
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
