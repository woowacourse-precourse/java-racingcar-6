package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final List<Car> carList;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carList = new ArrayList<Car>();
    }

    private void init() {
        List<String> carNameList = inputView.getInputNameList();
        inputView.getInputTurns();

        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }

    private void playTurn() {
        for (Car car : carList) {
            car.move();
            outputView.printTurnResult(car.getName(), car.getProgress());
        }
    }

    private void findWinner() {
        Car maximum = carList.stream().max(Comparator.comparing(Car::getProgress))
                .orElse(null);

        if (maximum == null) {
            return;
        }

        List<String> winner = carList.stream().filter(car -> car.isSame(maximum))
                .map(Car::getName).toList();
        outputView.printWinner(winner);
    }

    public void run() {
        init();
        while (inputView.checkTurnOver()) {
            playTurn();
        }
        findWinner();
    }
}
