package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.dto.RaceGameInfoDto;
import racingcar.util.Randoms;
import racingcar.view.ExecutionView;

import java.util.List;
import java.util.stream.IntStream;

public class RaceGameService {

    private static final int START_NUMBER = 0;

    private ExecutionView executionView;

    public RaceGameService() {
        this.executionView = new ExecutionView();
    }

    public RaceCars run(RaceGameInfoDto raceGameInfoDto) {
        printRunMessage();
        final RaceCars raceCars = raceGameInfoDto.getRaceCars();
        final int attemptCount = raceGameInfoDto.getAttemptCount();

        IntStream.range(START_NUMBER, attemptCount)
                .forEach(i -> executeRaceForCars(raceCars));

        return raceCars;
    }

    private void printRunMessage() {
        executionView.newLine();
        executionView.printExecutionStartMessage();
    }

    private void executeRaceForCars(RaceCars raceCars) {
        List<Car> cars = raceCars.getCars();

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
