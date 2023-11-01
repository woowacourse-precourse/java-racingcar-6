package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGameService {

    public void startRacingCarGame(OutputView outputView, List<RacingCar> racingCars, int numberOfRound) {
        for (int i = 0; i < numberOfRound; i++) {
            runEachRound(outputView, racingCars);
            System.out.println();
        }
    }

    private static void runEachRound(OutputView outputView, List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            moveForwardFitCondition(racingCar);
            outputView.printRoundResult(racingCar);
        }
    }

    private static void moveForwardFitCondition(RacingCar racingCar) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            racingCar.setForward(1);
        }
    }
}
