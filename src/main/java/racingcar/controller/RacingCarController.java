package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView();
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