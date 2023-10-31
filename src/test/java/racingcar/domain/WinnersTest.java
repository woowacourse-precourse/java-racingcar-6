package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.DriveBehavior;
import racingcar.domain.car.RandomDriveBehavior;

public class WinnersTest {
    @ParameterizedTest
    @MethodSource("provideRacingCars")
    void 우승자를_구한다(RacingCars racingCars) {
        Winners winners = Winners.create(racingCars.getCars());
        List<String> winnerNames = winners.getWinners().stream()
                .map(Car::getName)
                .toList();

        assertThat(winnerNames).isEqualTo(List.of("car1", "car4"));
    }

    static Stream<RacingCars> provideRacingCars() {
        List<Car> cars = createCarsWithNames("car1", "car2", "car3", "car4", "car5");

        driveForwardRepeatedly(cars.get(0), 5);
        driveForwardRepeatedly(cars.get(1), 4);
        driveForwardRepeatedly(cars.get(2), 3);
        driveForwardRepeatedly(cars.get(3), 5);
        driveForwardRepeatedly(cars.get(4), 0);

        return Stream.of(new RacingCars(cars));
    }

    private static List<Car> createCarsWithNames(String... names) {
        DriveBehavior driveForwardBehavior = new RandomDriveBehavior(() -> 4);
        return Stream.of(names)
                .map(name -> Car.createOnStart(driveForwardBehavior, name))
                .toList();
    }

    private static void driveForwardRepeatedly(Car car, int count) {
        for (int i = 0; i < count; i++) {
            car.drive();
        }
    }
}
