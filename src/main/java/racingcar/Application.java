package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.view.GameStartEndView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameStartEndView gameStartEndView = new GameStartEndView();
        RaceGameController raceGameController = new RaceGameController(gameStartEndView);
        raceGameController.start();
    }
}
