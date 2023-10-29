package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.domain.Vehicle;
import racingcar.util.RandomNumber;
import racingcar.view.InputView;

public class RacingGameController {

    private static final int ATTEMPT_END_NUMBER = 0;
    private static final int ADVANCE_MIN_NUMBER = 4;

    private List<Vehicle> registeredCars;
    private Integer attemptNumber;

    public RacingGameController() {
        initGame();
    }

    public void initGame() {
        registeredCars = makeCarList();
        attemptNumber = Integer.parseInt(InputView.inputAttemptNumber());
    }

    private List<Vehicle> makeCarList() {
        String carNames = InputView.inputCarNames();
        return Arrays.stream(carNames.split(","))
                .map(carName -> carName.trim())
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public void isAdvanceOrStop() {
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
