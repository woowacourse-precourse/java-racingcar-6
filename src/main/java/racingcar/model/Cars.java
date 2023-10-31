package racingcar.model;

import racingcar.utils.RandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static racingcar.utils.ErrorMessage.CAN_NOT_FIND_MAX_POSITION;

public class Cars {
    private static final String REGEX = ",";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String names) {
        List<Car> newCars = Arrays.stream(names.split(REGEX))
                .map(Car::of)
                .toList();
        return new Cars(newCars);
    }

    static Cars ofWithCount(String names, int count) {
        List<Car> newCars = Arrays.stream(names.split(REGEX))
                .map(name -> Car.ofWithPosition(name, count))
                .toList();
        return new Cars(newCars);
    }


    public Cars moves(RandomGenerator randomNumber) {
        List<Car> newCars = cars.stream()
                .map(car -> car.move(randomNumber))
                .toList();
        return new Cars(newCars);
    }


    public String winners() {
        Position position = getMaxPosition();
        return getWinners(position);
    }

    private String getWinners(Position position) {
        StringJoiner stringJoiner = new StringJoiner(REGEX);
        cars.stream()
                .filter(car -> car.isWinner(position))
                .forEach(car -> stringJoiner.add(car.getName()));

        return stringJoiner.toString();
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_FIND_MAX_POSITION.getMessage()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    /*
    * 자동차들의 이름과 위치를 반환한다.
    * ex) pobi : --
    *    crong : ---
    *   honux : -
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        cars.forEach(car -> stringJoiner.add(car.toString()));
        return stringJoiner.toString();
    }
}
