package sample;

import java.awt.*;
import java.util.Random;

public class Game extends Frame implements Runnable {
    private static final long serialVersionUID = 1L;

    Snake snake;
    RedApple apple;
    Border border;

    public Game() {
        super("SNAKE");
        pack();
        resize(600, 600);
        addMenus();
        snake = new Snake();
        apple = new RedApple();
        border = new Border();
        show();
    }

    public void run() {
        while ((snake.alive)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.step();
            changeLocation();
            death();
            repaint();
            snake.repaint();
        }
    }

    void addMenus() {
        MenuBar bar = new MenuBar();
        Menu game = new Menu("Game");
        Menu help = new Menu("Help");
        game.add(new MenuItem("New"));
        game.add(new MenuItem("Quit"));
        help.add(new MenuItem("About"));
        help.add(new MenuItem("Help"));
        bar.add(game);
        bar.add(help);
        setMenuBar(bar);
    }

    public void paint(Graphics g) {
        snake.paint(g);
        apple.paint(g);
        border.paint(g);
    }

    public void changeLocation() {
        Point point = (Point) snake.part.Last();
        System.out.println(apple.location.x + "-" + apple.location.y);
        System.out.println(point.x + "+" + point.y);
        if ((point.x == apple.location.x) && (point.y == apple.location.y)) {
            Random rnd = new Random();
            apple = new RedApple(rnd.nextInt(55)+2, rnd.nextInt(51)+6);
            snake.ate = true;
        } else {
            snake.ate = false;
        }
    }

    public void death(){
        Point point = (Point) snake.part.Last();
        if ((point.x==1)||(point.x==58)||(point.y==5)||(point.y==58)){
            snake.alive=false;
        }
    }

    public boolean handleEvent(Event event) {
        if (event.id == Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;
        } else {
            if ((event.id == Event.ACTION_EVENT)
                    && (event.target instanceof MenuItem)) {
                if ("Quit".equals(event.arg)) {
                    System.exit(0);
                    return true;
                }
                return true;
            }
        }

        if (event.id == Event.KEY_ACTION) {
            if (event.key == Event.DOWN) {
                snake.turnDown();
                return true;
            }
            if (event.key == Event.UP) {
                snake.turnUp();
                return true;
            }
            if (event.key == Event.LEFT) {
                snake.turnLeft();
                return true;
            }
            if (event.key == Event.RIGHT) {
                snake.turnRight();
                return true;
            }
            if (event.key == Event.ESCAPE) {
                System.exit(0);
                return true;
            }
        }

        return false;
    }
}
