package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarDistanceMessage> forwardCars() {

        List<CarDistanceMessage> messages = new ArrayList<>();

        for (Car car : cars) {
            RandomNumber number = RandomNumber.createRandomNumber();
            if (number.isMovable()) car.move();
        }

        for (Car car : cars) {
            messages.add(car.createCarDistanceMessage());
        }

        return messages;

    }

    public WinnersMessage getWinnersMessage() {
        Integer farthest = getFarthestDistance();
        List<Car> winners = getWinners(farthest);
        return new WinnersMessage(winners);
    }

    private List<Car> getWinners(Integer farthest) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance().equals(farthest)) {
                winners.add(car);
            }
        }
        return Collections.unmodifiableList(winners);
    }

    private Integer getFarthestDistance() {
        int farthest = 0;
        for (Car car : cars) {
            farthest = Math.max(farthest, car.getDistance());
        }
        return farthest;
    }

}
