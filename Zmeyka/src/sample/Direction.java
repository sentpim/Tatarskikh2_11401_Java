package sample;

public class Direction                    // �����������
{
    public final static int RIGHT = 0;    //
    public final static int DOWN = 1;    //
    public final static int LEFT = 2;    //
    public final static int UP = 3;        //

    public int state;                    // ������� �����������

    public Direction()                    // �����������, ������� ������������ �����������
    {

    }

    public void changeToRight()            // ������ ������� ����������� �� RIGHT
    {
        if (state != LEFT)
            state = RIGHT;
    }

    public void changeToDown()            // ������ ������� ����������� �� DOWN
    {
        if (state != UP)
            state = DOWN;
    }

    public void changeToLeft()            // ������ ������� ����������� �� LEFT
    {
        if (state != RIGHT)
            state = LEFT;
    }

    public void changeToUp()            // ������ ������� ����������� �� UP
    {
        if (state != DOWN)
            state = UP;
    }
}