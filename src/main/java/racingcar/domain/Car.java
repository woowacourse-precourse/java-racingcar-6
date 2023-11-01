package racingcar.domain;

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

    private String getName() {
        return name;
    }

    private Integer getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car car) {
            return name.equals(car.name) && distance.equals(car.distance);
        }
        return false;
    }

    public static WinnersMessage createWinnersMessage(List<Car> cars) {
        Integer farthest = getFarthestDistance(cars);
        List<Car> winners = getWinners(cars, farthest);
        return new WinnersMessage(getNames(winners));
    }

    private static Integer getFarthestDistance(List<Car> cars) {
        int farthest = 0;
        for (Car car : cars) farthest = Math.max(farthest, car.getDistance());
        return farthest;
    }

    private static List<Car> getWinners(List<Car> cars, Integer farthest) {
        return cars.stream()
                .filter(car -> car.getDistance().equals(farthest))
                .toList();
    }

    private static List<String> getNames(List<Car> winners) {
        return winners.stream().map(Car::getName).toList();
    }

}
