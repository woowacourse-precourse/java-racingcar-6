package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void start() {
        String[] carNames = InputView.inputCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            CarNameValidator.validateCarName(carName);
            cars.add(new Car(carName));
        }

        CarNameValidator.validateCarName(cars);

        String inputTryCount = InputView.inputTryCount();
        TryCountValidator.validateTryCount(inputTryCount);
        int tryCount = Integer.parseInt(inputTryCount);

        Race race = new Race(cars, tryCount);

        for (int i = 0; i < tryCount; i++) {
            race.startOfRace();
            carMovingStatus(race.getCars());
        }

        OutputView.printFinalWinners(race.getWinners());
    }

    private void carMovingStatus(List<Car> cars) {
        List<String> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            carStatuses.add(car.getNameAndProgress());
        }

        OutputView.printCarMovingStatus(carStatuses);
    }
}
