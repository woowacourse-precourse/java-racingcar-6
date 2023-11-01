package racingcar.domain;

import java.util.List;

public class Game {
    private List<Car> carList;
    private int count;

    private Game(){}

    public static Game createGame(List<Car> carList, int count){
        Game game = new Game();
        game.carList = carList;
        game.count = count;

        return game;
    }
}
