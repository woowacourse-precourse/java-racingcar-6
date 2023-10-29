package racingcar.domain;

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
        int furthestDistance = findFurthestDistance();
        List<Winner> winnerList = getWinnersByCheckDistance(furthestDistance);
        return new Winners(winnerList);
    }

    private List<Winner> getWinnersByCheckDistance(int furthestDistance) {
        return cars.stream()
                .filter(car -> car.isFurthestDistance(furthestDistance))
                .map(car -> car.recognizeAsWinner())
                .collect(Collectors.toList());
    }

    private int findFurthestDistance() {
        int position = START_LINE;
        for (Car car : cars) {
            position = car.comparePosition(position);
        }
        return position;
    }
}
