package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;

public class WinnersTest {
    @ParameterizedTest
    @MethodSource("provideRacingCars")
    void 우승자를_구한다(RacingCars racingCars) {
        racingCars.driveCars();

        Winners winners = Winners.create(racingCars.getCars());
        List<String> winnerNames = winners.getWinners().stream()
                .map(Car::getName)
                .toList();

        assertThat(winnerNames).isEqualTo(List.of("car1", "car4"));
    }

    static Stream<RacingCars> provideRacingCars() {
        return Stream.of(new RacingCars(createCars()));
    }

    private static List<Car> createCars() {
        return List.of(
                Car.createOnStart(() -> 5, "car1"),
                Car.createOnStart(() -> 4, "car2"),
                Car.createOnStart(() -> 3, "car3"),
                Car.createOnStart(() -> 5, "car4"),
                Car.createOnStart(() -> 0, "car5")
        );
    }
}
