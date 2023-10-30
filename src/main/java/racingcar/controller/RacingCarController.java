package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarController {
    private static final int FORWARD_RULE = 4;
    private static final char COMMA = ',';
    private static final String EMPTY_NAME = "";
    private static final String JOINING_RULE = ", ";
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void racingCar() {
        List<Car> cars = createCarList();
        String inputNumberOfTimes = inputView.inputNumberOfTimes();
        validateInputIsNumber(inputNumberOfTimes);
        int numberOfTimes = Integer.parseInt(inputNumberOfTimes);
        IntStream.range(0, numberOfTimes)
                .forEach(i -> repeatRaceNumberOfTimes(cars));
        outputView.printWinnerOrWinners(findWinner(cars));
    }

    private String findWinner(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance(cars))
                .map(Car::getName)
                .collect(Collectors.joining(JOINING_RULE));
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
        validateLastCharComma(input);
        Cars cars = new Cars(splitCarNamesByComma(input));
        return cars.getCars();
    }

    private List<String> splitCarNamesByComma(String input) {
        List<String> carNames = Arrays.stream(input.split(String.valueOf(COMMA)))
                .toList();
        validateEmptyName(carNames);
        return carNames;
    }

    private void validateEmptyName(List<String> carNames){
        if(carNames.contains(EMPTY_NAME)){
            throw new IllegalArgumentException("빈칸은 이름이 될 수 없습니다.");
        }
    }

    private void validateLastCharComma(String input){
        int lastIndex = input.length() - 1;
        if(input.charAt(lastIndex) == COMMA){
            throw new IllegalArgumentException("빈칸은 이름이 될 수 없습니다.");
        }
    }

    private void validateInputIsNumber(String input) {
        boolean isCharAllNumbers = input.chars()
                .allMatch(Character::isDigit);

        if (!isCharAllNumbers) {
            throw new IllegalArgumentException("시도 횟수 입력이 숫자가 아닙니다.");
        }
    }
}