package racingcar.controller;

import java.util.List;
import racingcar.model.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final CarRepository carRepository = CarRepository.INSTANCE;

    public void run() {
        carRepository.clearCarList();
        List<String> carName = InputView.inputCarName();
        carRepository.addCar(carName);
        int numberOfExecute = InputView.inputNumberOfExcution();

        OutputView.printResult();
        for(int i=0; i<numberOfExecute; i++) {
            carRepository.go();
            OutputView.printCarsResult(carRepository);
        }
        OutputView.printWinner(carRepository);
    }
}
