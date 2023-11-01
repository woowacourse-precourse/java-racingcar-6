package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.util.Validation;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingController {

    private final RacingService racingService;

    public RacingController() {
        racingService = new RacingService();
    }

    public void start() {
        List<Car> cars = inputCar();
        int racingCount = inputRacingCount();

        OutputView.printStartRacing();
        repeatRace(cars, racingCount);

        String winner = racingService.winnerToString();
        OutputView.printFinalWinner(winner);
    }

    private List<Car> inputCar() {
        OutputView.printInputCarName();
        String cars = InputView.inputCarName();
        Validation.checkAll(cars);

        return getCars(cars);
    }

    private List<Car> getCars(String cars) {
        List<Car> carList = RacingService.convertToCarList(cars);
        racingService.saveCars(carList);

        return carList;
    }

    private static int inputRacingCount() {
        OutputView.printInputRacingCount();
        return InputView.inputRacingCount();
    }

    private void repeatRace(List<Car> cars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            racingService.race();
            OutputView.carResult(cars.stream()
                    .map(Car::toDTO)
                    .collect(Collectors.toList())
            );
        }
    }
}