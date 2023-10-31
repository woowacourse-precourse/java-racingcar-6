package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class CarService {
    public RacingCars getCarNames(){
        OutputView.inputCarNamesMessage();
        return new RacingCars(InputView.readCarNames());
    }
}
