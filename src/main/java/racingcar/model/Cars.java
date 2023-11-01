package racingcar.model;

import racingcar.constant.SeparatorConstant;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;
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
        for (Car car : carList) {
            car.dashByRandNum();
        }
    }

    public String getRacingResult() {
        return carList.stream()
                .map(Car::getRacingResult)
                .collect(Collectors.joining("\n", "", "\n"));
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
                .orElse("");
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
