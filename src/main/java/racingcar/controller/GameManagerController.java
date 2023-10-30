package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.request.CarNameRequest;
import racingcar.dto.request.TotalRoundNumberRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameManagerController {
    private List<CarNameRequest> getCarNames() {
        OutputView.printCarNameInputQuestion();
        return InputView.requestCarNames();
    }

    private Cars createCars() {
        final List<Car> carList = getCarNames().stream().map(c -> new Car(c.getName())).toList();
        return new Cars(carList);
    }

    private TotalRoundNumberRequest getTotalRoundNumber() {
        OutputView.printTotalRoundInputQuestion();
        return InputView.requestTotalRoundNumber();
    }
}
