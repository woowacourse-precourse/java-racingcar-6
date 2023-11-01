package racingcar.service;

import static racingcar.constant.PositionConstant.FORWARD_THRESHOLD;

import racingcar.domain.Car;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.Validator;
import racingcar.view.Output;

import java.util.Arrays;
import java.util.List;

public class Simulator {
    private final Validator validator = new Validator();
    private List<Car> cars;
    private int trial;

    public void setRace(String userInput, int moveInput) {
        cars = Arrays.stream(userInput.split(","))
                .map(String::trim).map(Car::new).toList();
        validator.validateTrial(moveInput);
        this.trial = moveInput;
    }

    public List<Car> startRace() {
        for (int i = 0; i< trial; ++i) {
            eachCarForward();
            Output.printEmptySpace();
        }
        return this.cars;
    }

    public void eachCarForward() {
        for (Car car: cars) {
            if (canForward()) {
                car.forward();
            }
            Output.displayRaceProgress(car.getName(), car.getPosition());
        }
    }

    private boolean canForward() {
        int randomNumber = RandomNumberGenerator.getRandomNumber();
        return randomNumber >= FORWARD_THRESHOLD.getValue();
    }

}
