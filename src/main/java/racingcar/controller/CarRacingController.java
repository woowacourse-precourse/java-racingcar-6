package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.RaceGame;
import racingcar.view.OutputView;

public class CarRacingController {
    private static final int RACECAR_ADVENCE_NUMBER = 4;
    private int randomNumber;
    private boolean AdvenceState;
    private int winerMoveCount;
    RandomUtility randomUtillity = new RandomUtility();
    OutputView outputView = new OutputView();

    public void playGame(RaceGame raceGame) {
        saveResetCarMoveCounts(raceGame);

        for (int round = 1; round <= raceGame.getRaceNumber(); round++) {
            repeatCarRace(raceGame);
        }

        decicdeWinner(raceGame);
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
            outputView.printRaceResult(raceGame.getCarNames().get(raceCarIndex),
                    raceGame.getCarMoveCounts().get(raceCarIndex));
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
    }

    public void decicdeWinner(RaceGame raceGame) {
        winerMoveCount = getWinnerMoveCount(raceGame.getCarMoveCounts());
        getWinnerCarNames(raceGame, winerMoveCount);
    }

    private int getWinnerMoveCount(List<String> carMoveCounts) {
        int winerMoveCount = 0;
        for (int i = 0; i < carMoveCounts.size(); i++) {
            if (winerMoveCount < carMoveCounts.get(i).length()) {
                winerMoveCount = carMoveCounts.get(i).length();
            }
        }

        return winerMoveCount;
    }

    private void getWinnerCarNames(RaceGame raceGame, int winnerMoveCount) {
        List<String> winnerCarName = new ArrayList<>();
        for (int i = 0; i < raceGame.getCarMoveCounts().size(); i++) {
            if (winnerMoveCount == raceGame.getCarMoveCounts().get(i).length()) {
                winnerCarName.add(raceGame.getCarNames().get(i));
            }
        }
        raceGame.setWinnerCarNames(winnerCarName);
    }
}
