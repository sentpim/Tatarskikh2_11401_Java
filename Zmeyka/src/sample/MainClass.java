package sample;
import sample.Game;

public class MainClass
{
    static Game game;

    public static void main(String[] args)
    {
        game = new Game();
        game.run();
    }
}