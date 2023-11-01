package racingcar.game;

import racingcar.domain.Car;
import racingcar.util.InputManager;
import racingcar.util.PrintManager;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static List<Car> players;

    public static void play() throws IllegalArgumentException{
        InputManager inputManager = new InputManager();
        PrintManager.printInputCarName();
        players = inputManager.getPlayerCarList();

        PrintManager.printInputTryTimes();
        int m = inputManager.getTryTimes();
        PrintManager.printSeparateStage();

        PrintManager.printPlayResultStart();
        for(int i = 0 ; i < m ; i++){
            moveCars();
        }
        PrintManager.printFinalResult(findWinners(players));
    }

    private static void moveCars() {
        for(Car car : players){
            car.randomMove();
            PrintManager.printGameResult(car);
        }
        PrintManager.printSeparateStage();
    }

    private static List<Car> findWinners(List<Car> carList){
        List<Car> winner = new ArrayList<>();
        int highScore = 0;
        for(Car car : carList){
            int score = car.getLocation();
            if(score > highScore){
                highScore = score;
                winner.clear();
                winner.add(car);
            }
            else if(score == highScore){
                winner.add(car);
            }
        }
        return winner;
    }
}
