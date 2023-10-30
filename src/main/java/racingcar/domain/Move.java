package racingcar.domain;

import racingcar.view.InputView;

public class Move {
    public Move() {
    }

    public static int inputNumberOfTries() {
        final int numberOfTries = Integer.parseInt(InputView.printInputNumberOfGamesMessage());
        return numberOfTries;
    }

    public int generateRandomNumber() {
        return 0;
    }

    public void moveCar() {

    }

    public String movingDistance() {
        return null;
    }
}
