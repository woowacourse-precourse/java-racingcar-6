package racingcar;

import racingGame.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController();

        raceController.start();
    }
}
