package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private static final int CAR_MAXIMUM_NUMBER = 10;
    List<Car> cars;

    public Cars(List<String> carNameList) {
        cars = new ArrayList<>();
        addCarInCars(carNameList);
    }

    public void playTurn() {
        moveCars();
        printResultOfTurn();
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        cars.sort(Comparator.reverseOrder());
        Car firstWinner = cars.get(0);
        for (Car car : cars) {
            if (car.compareTo(firstWinner) == 0) {
                winners.add(car);
                continue;
            }
            break;
        }
        return winners;
    }

    private void printResultOfTurn() {
        OutputView.printFirstShownResultText();
        for (Car car : cars) {
            car.printPresentMovingDistance();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.moveRandomly();
        }
    }

    private void addCarInCars(List<String> carNameList) {
        validateCarsMaximumNumber();
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }
    }

    private void validateCarsMaximumNumber() {
        if (cars.size() >= CAR_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("차의 개수는 %d 을 넘어갈 수 없습니다.", CAR_MAXIMUM_NUMBER));
        }
    }
}
