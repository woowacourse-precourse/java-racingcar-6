package racingcar.car;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import racingcar.game.MoveResults;
import racingcar.game.Winner;
import racingcar.utils.generator.RaceMoveNumberGenerator;

public class Cars {
    public static final String NAMES_SPLIT_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String carsName) {
        String[] splitCarsName = carsName.split(NAMES_SPLIT_DELIMITER);
        this.cars = Arrays.stream(splitCarsName)
                .map(carName -> new Car(new CarName(carName), new Position(0)))
                .toList();
    }

    public MoveResults tried() {
        MoveResults moveResults = new MoveResults();
        for (Car car : cars) {
            moveResults.add(car.move(RaceMoveNumberGenerator.generate()));
        }
        return moveResults;
    }

    public Winner getWinner() {
        Position maxPosition = getMaxPosition();
        return new Winner(cars.stream()
                .filter(car -> car.getPosition().getPosition() == maxPosition.getPosition())
                .toList());
    }

    private Position getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(car -> car.getPosition().getPosition()))
                .get()
                .getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
