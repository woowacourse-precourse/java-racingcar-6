package racingcar.domain;

import racingcar.utils.GenerateRandomNumber;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars =  cars;
    }

    public void moveOrStop() {
        for (Car car : cars) {
            car.goForward(GenerateRandomNumber.generateRandomNumber());
        }
    }

    public void showResult() {
        OutputView.printResult(cars);
    }

    public void showFinalWinner() {
        OutputView.printFinalWinner(getFinalWinner());
    }

    private List<Car> getFinalWinner() {
        int maxMovement = getMaxMovement();
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .collect(Collectors.toList());
    }

    private int getMaxMovement() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getMovement))
                .get()
                .getMovement();
    }

    public List<Car> getCars() {
        return cars;
    }
}
