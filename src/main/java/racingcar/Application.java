package racingcar;

import racingcar.view.InputValues;
import racingcar.view.OutputValues;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        OutputValues outputValues = new OutputValues();
        outputValues.carMovementOutput(3);
        outputValues.carRaceWinnerOutput("test");
        outputValues.runResultOutput();
        System.out.println(outputValues.carMovementOutput(3));
        // TODO: 프로그램 구현
    }
}
