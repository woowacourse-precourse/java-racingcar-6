package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingStart {
    public void start(String[] names, int roundCount) {
        RacingCars racingCars = new RacingCars(new ArrayList<>(Arrays.asList(names)));
        System.out.println("실행 결과");
        for (int i = 0; i < roundCount; i++) {
            OutputView.roundResult(racingCars.getRoundResult());
        }
        OutputView.printWinner(racingCars.getWinners());
    }
}
