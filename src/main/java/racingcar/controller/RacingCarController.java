package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final int FORWARD_RULE = 4;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private String findWinner(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance(cars))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int maxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 목록이 존재하지 않습니다."));
    }

    private void repeatRaceNumberOfTimes(List<Car> cars) {
        checkEachCarForward(cars);
        outputView.printEachRaceResult(cars);
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