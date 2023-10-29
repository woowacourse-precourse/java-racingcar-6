package racingcar.domain;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int START_LINE = 0;

    private final List<Car> cars;

    public Cars(CarNames carNames) {
        cars = carNames.assignNamesToCars();
    }

    public void moveAllCar() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateNumber();
            moveCarIfBiggerThanThree(randomNumber, car);
        }
    }

    public String getMoveResult() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining());
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
