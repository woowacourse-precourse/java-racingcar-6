package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final int FORWARD_RULE = 4;
    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView();
    }

    private void checkEachCarForward(List<Car> cars) {
        cars.forEach(this::checkAtLeastFour);
    }

    private void checkAtLeastFour(Car car) {
        if (randomNumber() >= FORWARD_RULE) {
            car.forward();
        }
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private List<Car> createCarList() {
        String input = inputView.inputCarNames();
        Cars cars = new Cars(splitCarNamesByComma(input));
        return cars.getCars();
    }

    private List<String> splitCarNamesByComma(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}