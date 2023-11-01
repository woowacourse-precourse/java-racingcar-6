package racingcar.domain;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    public static void moveForward(int i) {
        int[] userForwardMovement = new int[InputView.getNumberOfCars()];
        int carIndex = i;
        userForwardMovement[i] ++;
    }
}