package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RaceGame;

public class CarRacingController {
    private static final int RACECAR_ADVENCE_NUMBER = 4;
    private int randomNumber;
    private boolean AdvenceState;
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
            AdvenceState = checkAdvenceAndStop(randomNumber);
            if (AdvenceState) {
                increaseAdvenceCount(raceGame, raceCarIndex);
            }
        }
        System.out.println();
    }

    private boolean checkAdvenceAndStop(int randomNumber) {
        return randomNumber >= RACECAR_ADVENCE_NUMBER;
    }

    private void increaseAdvenceCount(RaceGame raceGame, int raceCarIndex) {
        String updateCount = raceGame.getCarMoveCounts().get(raceCarIndex) + "-";

        raceGame.getCarMoveCounts().set(raceCarIndex, updateCount);
        raceGame.setCarMoveCounts(raceGame.getCarMoveCounts());
        System.out.println(raceGame.getCarMoveCounts());
    }
}
