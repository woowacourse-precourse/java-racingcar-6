package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RaceGame;

public class CarRacingController {

    public void playGame(RaceGame raceGame) {
        saveResetCarMoveCounts(raceGame);
    }

    private void saveResetCarMoveCounts(RaceGame raceGame) {
        List<String> resetCarMoveCounts = new ArrayList<>();
        for (int i = 0; i < raceGame.getCarNames().size(); i++) {
            resetCarMoveCounts.add("");
        }
        raceGame.setCarMoveCounts(resetCarMoveCounts);
        System.out.println(raceGame.getCarMoveCounts());
    }
}
