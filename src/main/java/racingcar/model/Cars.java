package racingcar.model;

import racingcar.util.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        List<String> splitedCarNameList = splitCarNames(carNames);
        InputValidator.checkCarNameInputValidation(splitedCarNameList);
        addCarNameAtCarNameList(splitedCarNameList);
    }

    private void addCarNameAtCarNameList(List<String> carNameList) {
        cars = new ArrayList<>();
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public void moveForwardByRandomNumber() {
        for (Car car : cars) {
            car.canIMove();
        }
    }

    public List<String> sendRacingGameWinner() {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Car car : cars) {
            max = car.findMaxDistance(max);
        }
        for (Car car : cars) {
            if (car.isSameDistance(max)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
