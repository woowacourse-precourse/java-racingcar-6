package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RaceGame;

public class CarRacingController {
    private int randomNumber;
    RandomUtility randomUtillity = new RandomUtility();

    public void playGame(RaceGame raceGame) {
        saveResetCarMoveCounts(raceGame);

        for (int round = 1; round <= raceGame.getRaceNumber(); round++) {
            repeatCarRace(raceGame);
        }
    }

    private void saveResetCarMoveCounts(RaceGame raceGame) {
        List<String> resetCarMoveCounts = new ArrayList<>();
        for (int i = 0; i < raceGame.getCarNames().size(); i++) {
            resetCarMoveCounts.add("");
        }
        raceGame.setCarMoveCounts(resetCarMoveCounts);
    }

    public void repeatCarRace(RaceGame raceGame) {
        for (int raceCarIndex = 0; raceCarIndex < raceGame.getCarNames().size(); raceCarIndex++) {
            randomNumber = randomUtillity.generateRandomNumber();
            System.out.println(randomNumber);
        }
        System.out.println();
    }
}
