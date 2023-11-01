package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.dto.PrintCarDetailsDto;
import racingcar.dto.RaceGameInfoDto;
import racingcar.dto.WinnerCarDto;
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

    public WinnerCarDto run(RaceGameInfoDto raceGameInfoDto) {
        printRunMessage();
        final RaceCars raceCars = raceGameInfoDto.raceCars();
        final int attemptCount = raceGameInfoDto.attemptCount();

        IntStream.range(START_NUMBER, attemptCount)
                .forEach(i -> executeRaceForCars(raceCars));

        return new WinnerCarDto(getWinnerNames(raceCars));
    }

    private void printRunMessage() {
        executionView.newLine();
        executionView.printExecutionStartMessage();
    }

    private void executeRaceForCars(RaceCars raceCars) {
        List<Car> cars = raceCars.getCars();

        for (Car car : cars) {
            controlCarMovement(car, Randoms.getNumber());
            executionView.printExecutionMessage(new PrintCarDetailsDto(car));
        }
        executionView.newLine();
    }

    private void controlCarMovement(Car car, int controlValue) {
        car.controlMovement(controlValue);
    }

    private String getWinnerNames(RaceCars raceCars) {
        return raceCars.getWinningCarNames();
    }

}
