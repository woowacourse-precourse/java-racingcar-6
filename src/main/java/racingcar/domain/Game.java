package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarDistanceMessage> simulate() {
        moveRandomCars();
        return getCarDistanceMessages();
    }

    private void moveRandomCars() {
        for (Car car : cars) {
            RandomNumber number = RandomNumber.createRandomNumber();
            if (number.isMovable()) car.move();
        }
    }

    private List<CarDistanceMessage> getCarDistanceMessages() {
        List<CarDistanceMessage> messages = new ArrayList<>();
        for (Car car : cars) {
            messages.add(car.createCarDistanceMessage());
        }
        return messages;
    }

    public WinnersMessage getWinnersMessage() {
        return Car.createWinnersMessage(Collections.unmodifiableList(cars));
    }

}
