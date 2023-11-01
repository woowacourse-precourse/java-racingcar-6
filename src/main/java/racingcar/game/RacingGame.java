package racingcar.game;

import racingcar.domain.Car;
import racingcar.util.InputManager;
import racingcar.util.PrintManager;

import java.util.List;

public class RacingGame {

    private static List<Car> players;

    public static void play() throws IllegalArgumentException{
        InputManager inputManager = new InputManager();
        PrintManager.printInputCarName();
        players = inputManager.getPlayerCarList();

        PrintManager.printInputTryTimes();
        int m = inputManager.getTryTimes();

        PrintManager.printPlayResultStart();
        for(int i = 0 ; i < m ; i++){
            moveCars();
        }
        PrintManager.printFinalResult();
    }

    private static void moveCars() {
        for(Car car : players){
            car.randomMove();
            PrintManager.printGameResult(car);
        }
    }
}
