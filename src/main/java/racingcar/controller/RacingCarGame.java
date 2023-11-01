package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingCarList;
import racingcar.service.Referee;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private static final String SEPARATOR = ",";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private List<RacingCar> getRacingCarsFromInput() {
        String racingCarNames = inputView.getRacingCarNames();
        String[] carNames = racingCarNames.split(SEPARATOR);
        InputValidator.validateRacingCarNames(carNames);

        return RacingCarList.generateRacingCarList(carNames);
    }

    private int getTryCountFromInput() {
        String tryCountString = inputView.getTryCount();
        InputValidator.validateTryCount(tryCountString);

        return Integer.parseInt(tryCountString);
    }

    private void startRace(List<RacingCar> racingCars, int tryCount) {
        outputView.printExecutionResult();

        for (int i = 0; i < tryCount; i++) {
            RacingCarList.moveAllRacingCarsForward(racingCars);

            List<String> carsStatus = RacingCarList.generateAllRacingCarsStatusList(racingCars);
            outputView.printRacingCarStatus(carsStatus);
        }
    }

    private void printGameResults(List<RacingCar> racingCars) {
        String winners = Referee.generateRaceWinnersList(racingCars);
        outputView.printGameWinner(winners);
    }

}