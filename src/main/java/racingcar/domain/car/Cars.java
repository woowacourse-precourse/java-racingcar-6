package racingcar.domain.car;

import java.util.List;
import racingcar.domain.car.dto.CreateCars;
import racingcar.domain.game.MoveResult;
import racingcar.domain.game.RoundResult;
import racingcar.domain.move.MoveCommander;

public final class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateDuplicateCars(cars);
        this.cars = cars;
    }

    public static Cars from(final List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(final CreateCars createCars) {
        final List<Car> cars = createCars
                .carNames()
                .stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    private static void validateDuplicateCars(final List<Car> cars) {
        final int uniqueCarsSize = (int) cars.stream().distinct().count();
        final boolean hasDuplicateCarName = uniqueCarsSize != cars.size();

        if (hasDuplicateCarName) {
            throw new IllegalArgumentException();
        }
    }

    public RoundResult moveAllBy(final MoveCommander moveCommander) {
        final List<MoveResult> moveResults = cars.stream()
                .map(car -> car.movedBy(moveCommander.nextCommand()))
                .toList();

        return new RoundResult(moveResults);
    }

}
