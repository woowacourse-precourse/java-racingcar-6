package racingcar.car;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import racingcar.game.MoveResults;
import racingcar.utils.generator.RaceMoveNumberGenerator;

public class Cars {
    private final List<Car> cars;
    private final RaceMoveNumberGenerator generator = new RaceMoveNumberGenerator();

    public Cars(String carsName) {
        String[] splitCarsName = carsName.split(",");
        this.cars = Arrays.stream(splitCarsName)
                .map(carName -> new Car(new CarName(carName), new Position(0)))
                .toList();
    }

    public MoveResults tried() {
        MoveResults moveResults = new MoveResults();
        for (Car car : cars) {
            moveResults.add(car.move(generator.generateMoveNumber()));
        }
        return moveResults;
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
