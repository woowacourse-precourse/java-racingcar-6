package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    public static int[] userForwardMovement = new int[InputView.getNumberOfCars()];;
    public static void moveForward(int i) {
        userForwardMovement[i] = userForwardMovement[i] + 1;
    }

    public static int[] getUserForwardMovement() {
        return userForwardMovement;
    }
}