package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int START_LINE = 0;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = new ArrayList<>(carNames.size());
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> moveAllCar() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateNumber();
            moveCarIfBiggerThanThree(randomNumber, car);
        }
        return cars;
    }

    private void moveCarIfBiggerThanThree(int randomNumber, Car car) {
        if (randomNumber > 3) {
            car.move();
        }
    }

    public Winners findWinner() {
        List<String> winnerList = new ArrayList<>();
        int furthestDistance = findFurthestDistance();
        for (Car car : cars) {
            if (car.isFurthestDistance(furthestDistance)) {
                car.registerOnWinnerList(winnerList);
            }
        }
        return new Winners(winnerList);
    }

    private int findFurthestDistance() {
        int position = START_LINE;
        for (Car car : cars) {
            position = car.comparePosition(position);
        }
        return position;
    }
}
