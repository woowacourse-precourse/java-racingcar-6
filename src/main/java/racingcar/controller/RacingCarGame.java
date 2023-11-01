package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingCarList;
import racingcar.util.InputValidator;
import racingcar.view.InputView;

public class RacingCarGame {

    private static final String SEPARATOR = ",";

    InputView inputView = new InputView();

    private List<RacingCar> getRacingCarsFromInput() {
        String racingCarNames = inputView.getRacingCarNames();
        String[] carNames = racingCarNames.split(SEPARATOR);
        InputValidator.validateRacingCarNames(carNames);

        return RacingCarList.generateRacingCarList(carNames);
    }

}