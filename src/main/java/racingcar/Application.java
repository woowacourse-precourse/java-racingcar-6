package racingcar;

import racingcar.controller.CarRacingGame;

public class Application {


    public static void main(String[] args) {
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.start();
        carRacingGame.printAllTry(carRacingGame.getCars());
        carRacingGame.printWinner(carRacingGame.getCars());
    }
}
