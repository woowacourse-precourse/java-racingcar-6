package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class CarService {

    private RacingCars racingCars;

    public RacingCars getCarNames(){
        OutputView.inputCarNamesMessage();
        return new RacingCars(InputView.readCarNames());
    }
}
