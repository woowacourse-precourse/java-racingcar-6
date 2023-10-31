package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<Car> cars = inputView.receiveCarList();
        int times = inputView.receiveTimes();

        startRace(cars, times);

        List<String> winners = judgeRace(cars);
        outputView.printWinner(winners);
    }

    private void startRace(List<Car> cars, int times) {
        outputView.printRacingStart();
        for (int i = 0; i < times; i++) {
            cars.forEach(Car::move);
            System.out.println();
        }
    }

    private List<String> judgeRace(List<Car> cars) {
        cars.sort(Car::compareTo);
        int max_position = cars.get(0).getPosition();
        return cars.stream()
                .filter(c -> c.getPosition() == max_position)
                .map(Car::getName)
                .toList();
    }
}
