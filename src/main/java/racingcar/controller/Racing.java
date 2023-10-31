package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.ResultPerAttempt;
import racingcar.model.attempt.AttemptCount;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.Winners;
import racingcar.model.movement.Movement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {

    private final OutputView outputView;
    private final Cars cars;
    private final AttemptCount attemptCount;
    private final Movement movement;

    public Racing(InputView inputView, OutputView outputView, Movement movement) {
        this.outputView = outputView;
        this.movement = movement;
        System system = new System(inputView);
        cars = system.createCars();
        attemptCount = system.createAttemptCount();
    }

    public void run() {
        outputView.printOperationResultLetters();
        while (attemptCount.isNotZero()) {
            race();
            attemptCount.decrease();
        }
        showWinners();
    }

    private void race() {
        cars.race(movement);
        List<ResultPerAttempt> result = cars.getResult().stream()
                .map(ResultPerAttempt::new)
                .collect(Collectors.toList());
        outputView.showAttemptResult(result);
    }

    private void showWinners() {
        List<Car> winnerCars = cars.getWinners();
        Winners winners = new Winners(winnerCars);
        outputView.showWinners(winners);
    }
}
