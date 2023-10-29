package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    public static final int NAME_LENGTH_LIMIT = 5;
    public static final String ERR_NAME_IS_TOO_LONG = "자동차 이름의 길이는 %d자 이하여야 합니다.";
    private final String name;
    private Integer distance;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.distance = 0;
    }

    private static void validateLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT)
            throw new IllegalArgumentException(getNameIsTooLongErrorMessage());
    }

    private static String getNameIsTooLongErrorMessage() {
        return String.format(ERR_NAME_IS_TOO_LONG, NAME_LENGTH_LIMIT);
    }

    public void move() {
        distance++;
    }

    public CarDistanceMessage createCarDistanceMessage() {
        return new CarDistanceMessage(name, distance);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public static WinnersMessage createWinnersMessage(List<Car> cars) {
        Integer farthest = getFarthestDistance(cars);
        List<Car> winners = getWinners(cars, farthest);
        return new WinnersMessage(getNames(winners));
    }

    private static Integer getFarthestDistance(List<Car> cars) {
        int farthest = 0;
        for (Car car : cars) {
            farthest = Math.max(farthest, car.getDistance());
        }
        return farthest;
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

    private static List<String> getNames(List<Car> winners) {
        return winners.stream().map(Car::getName).toList();
    }

}
