package racingcar;

import racingcar.controller.RaceManager;

public class Application {
    public static void main(String[] args) {
        RaceManager race = new RaceManager();
        race.setCarNames();
        race.setAttemptNumber();
        race.printResult();
        race.printWinner();
    }
}
