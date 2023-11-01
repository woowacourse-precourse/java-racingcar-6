package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingController {

    private final RacingService racingService;

    public RacingController() {
        racingService = new RacingService();
    }

    public void start() {
        List<Car> cars = inputCar();
    }

    private List<Car> inputCar() {
        OutputView.printInputCarName();
        String cars = InputView.inputCarName();

        return getCars(cars);
    }

    private List<Car> getCars(String cars) {
        List<Car> carList = RacingService.convertToCarList(cars);
        RacingService.saveCars(carList);

        return carList;
    }
}