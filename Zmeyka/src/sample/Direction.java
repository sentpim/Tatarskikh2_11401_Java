package sample;

public class Direction                    // Направление
{
    public final static int RIGHT = 0;    //
    public final static int DOWN = 1;    //
    public final static int LEFT = 2;    //
    public final static int UP = 3;        //

    public int state;                    // Текущее направление

    public Direction()                    // Конструктор, создает произвольное направление
    {

    }

    public void changeToRight()            // Меняет текущее направление на RIGHT
    {
        if (state != LEFT)
            state = RIGHT;
    }

    public void changeToDown()            // Меняет текущее направление на DOWN
    {
        if (state != UP)
            state = DOWN;
    }

    public void changeToLeft()            // Меняет текущее направление на LEFT
    {
        if (state != RIGHT)
            state = LEFT;
    }

    public void changeToUp()            // Меняет текущее направление на UP
    {
        if (state != DOWN)
            state = UP;
    }
}