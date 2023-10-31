package racingcar.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.domain.Vehicle;
import racingcar.util.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private static final int ATTEMPT_END_NUMBER = 0;
    private static final int ADVANCE_MIN_NUMBER = 4;

    private List<Vehicle> registeredCars;
    private Integer attemptNumber;

    public RacingGameController() {
        registeredCars = new LinkedList<>();
        initGame();
    }

    public void initGame() {
        makeCarList();
        attemptNumber = Integer.parseInt(InputView.inputAttemptNumber());
    }

    public void startGame() {
        OutputView.outputExecuteResult();
        do {
            doAdvanceOrStop();
            OutputView.outputDistanceResult(registeredCars);
            attemptNumber--;
        } while (attemptNumber > ATTEMPT_END_NUMBER);

    }

    private void makeCarList() {
        int listIndex = 0;
        String carNames = InputView.inputCarNames();
        String[] carNameArray = Arrays.stream(carNames.split(","))
                .map(carName -> carName.trim())
                .toArray(String[]::new);

        for(String carName: carNameArray) {
            registeredCars.add(new Car(carName, listIndex++));
        }
    }

    public void doAdvanceOrStop() {
        Stream<Vehicle> vehicleStream = registeredCars.stream();
        vehicleStream.forEach(vehicle -> {
            Integer randomNumber = RandomNumber.makeRandomNumber();
            if (randomNumber >= ADVANCE_MIN_NUMBER) {
                vehicle.advance();
            }
        }
        );
    }
}
