package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import racingcar.view.InputView;

public class Race {
    public Race() {
    }

    public static int inputNumberOfTries() {
        final int numberOfTries = Integer.parseInt(InputView.printInputNumberOfGamesMessage());
        return numberOfTries;
    }

    public static int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    public static int moveCar(int randomNumber) {
        if (randomNumber >= 4) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
