package Model;

import java.util.ArrayList;

public class Game {

    private static Game game = null;
    private int round = 0;

    private ArrayList<Car> cars;

    private Game() {

    }

    public static Game getInstance() {
        if (Game.game == null) {
            return Game.game = new Game();
        }
        return Game.game;
    }


    public int getRound() {
        return this.round;
    }


}
