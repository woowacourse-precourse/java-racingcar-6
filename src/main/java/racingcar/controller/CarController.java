package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Constants;
import racingcar.model.Car;

public class CarController {
    private final List<Car> cars;

    public CarController(String carNames) {
        this.cars = toList(carNames);
    }

    private List<Car> toList(String carNames) {
        List<Car> cars = new ArrayList<>();

        String[] name = carNames.split(",");
        for (String s : name) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MOVE_NUMBER_MIN, Constants.MOVE_NUMBER_MAX);
            if (randomNumber >= Constants.MOVE_NUMBER_DEFAULT) {
                car.movePosition();
            }
        }

        printPositions();
    }

    private void printPositions() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }

            System.out.print("\n");
        }
    }

    public String getWinner() {
        List<String> winner = new ArrayList<>();

        int winnerPosition = findWinnerPosition();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winner.add(car.getName());
            }
        }

        return String.join(",", winner);
    }

    private int findWinnerPosition() {
        int winnerPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > winnerPosition) {
                winnerPosition = car.getPosition();
            }
        }

        return winnerPosition;
    }
}
