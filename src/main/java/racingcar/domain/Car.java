package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    public static final int NAME_LENGTH_LIMIT = 5;
    private final String name;
    private Integer distance;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.distance = 0;
    }

    private static void validateLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) throw new IllegalArgumentException();
    }

    public void move() {
        distance++;
    }

    public CarDistanceMessage getCarDistanceMessage() {
        return new CarDistanceMessage(name, distance);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public static WinnersMessage getWinnersMessage(List<Car> cars) {
        Integer farthest = getFarthestDistance();
        List<Car> winners = getWinners(cars, farthest);
        return new WinnersMessage(winners);
    }

    private static List<Car> getWinners(List<Car> cars, Integer farthest) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance().equals(farthest)) {
                winners.add(car);
            }
        }
        return Collections.unmodifiableList(winners);
    }

    private static Integer getFarthestDistance() {
        int farthest = 0;
        for (Car car : cars) {
            farthest = Math.max(farthest, car.getDistance());
        }
        return farthest;
    }

}
