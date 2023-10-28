package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.util.Randoms;
import racingcar.view.ExecutionView;

import java.util.List;
import java.util.stream.IntStream;

public class RaceGameService {
    private static final int START_NUMBER = 0;
    private final RaceCars raceCars;
    private final int attemptCount;
    private ExecutionView executionView;

    public RaceGameService(RaceCars raceCars, int attemptCount) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
        this.executionView = new ExecutionView();
    }

    public void run(){
        printRunMessage();
        final List<Car> cars = raceCars.getCars();

        IntStream.range(START_NUMBER, attemptCount)
                .forEach(i -> executeRaceForCars(cars));
    }

    private void printRunMessage() {
        executionView.newLine();
        executionView.printExecutionStartMessage();
    }

    private void executeRaceForCars(List<Car> cars) {
        for (Car car : cars) {
            controlCarMovement(car, Randoms.getNumber());
            executionView.printExecutionMessage(car);
        }
        executionView.newLine();
    }

    private void controlCarMovement(Car car, int controlValue) {
        car.controlMovement(controlValue);
    }

}
