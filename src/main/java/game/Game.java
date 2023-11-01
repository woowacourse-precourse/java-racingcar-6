package game;

import car.Car;
import util.GamePrinter;

import java.util.List;

public class Game {

    private List<Car> carList;

    private int count;

    private final GameReferee gameReferee = new GameReferee(new DefaultRandomGenerator());

    public Game(List<Car> carList, int count) {
        this.carList = carList;
        this.count = count;
    }

    public void run() {
        GamePrinter.startMove();
        for (int i = 0; i < count; i++) {
            gameReferee.allMove(carList);
            System.out.println();
        }
        gameReferee.determineWinner(carList);
    }

}
