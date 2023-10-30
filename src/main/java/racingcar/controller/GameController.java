package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.GoStopCar;
import racingcar.view.OutputView;

public class GameController {

    public void playGame(String carNamesInput, int numberOfAttempts) {
        List<Car> cars = createCars(carNamesInput);
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            moveCars(cars);
        }
        List<String> winners = determineWinners(cars);
        OutputView.printGameResult(cars, numberOfAttempts);
        OutputView.printWinners(winners);
    }

    private List<Car> createCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCar(Car car) {
        int randomNumber = GoStopCar.pickNumberInRange();
        if (randomNumber >= 4) {
            car.moveForward();
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
        OutputView.printCurrentPositions(cars);
    }

    private List<String> determineWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = Cars.getWinners(cars, maxPosition);
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}

