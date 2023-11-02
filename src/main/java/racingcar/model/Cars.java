package racingcar.model;

import racingcar.constant.SeparatorConstant;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;
    private static Cars instance;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars getInstance(List<Car> cars) {
        if(instance == null) {
            instance = new Cars(cars);
        }
        return instance;
    }

    public void racingCar() {
        carList.forEach(Car::dashByRandNum);
    }

    public String getRacingResult() {
        return carList.stream()
                .map(Car::getRacingResult)
                .collect(Collectors.joining(
                        SeparatorConstant.NEW_LINE.getValue(),
                        SeparatorConstant.EMPTY_STRING.getValue(),
                        SeparatorConstant.NEW_LINE.getValue()));
    }

    public String getRacingWinner() {
        if(winnerCount() == 1) {
         return getWinner();
        }
        return getWinners();
    }

    private String getWinner() {
        return carList.stream()
                .filter(car -> car.getDashNum() == maxDash())
                .map(Car::getWinnerName)
                .findAny()
                .orElse(SeparatorConstant.EMPTY_STRING.getValue());
    }

    private String getWinners() {
        return carList.stream()
                .filter(car -> car.getDashNum() == maxDash())
                .map(Car::getWinnerName)
                .collect(Collectors.joining(SeparatorConstant.WINNER_SEPARATOR.getValue()));
    }

    private int winnerCount() {
        return (int) carList.stream()
                .filter(car -> car.getDashNum() == maxDash())
                .count();
    }

    private int maxDash() {
        return carList.stream()
                .mapToInt(Car::getDashNum)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
