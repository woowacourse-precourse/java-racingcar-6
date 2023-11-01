package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;
import racingcar.domain.car.RacingGame;
import racingcar.domain.car.dto.RaceResult;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    @ParameterizedTest
    @DisplayName("경주를 마친 Car 리스트 중 최종 우승자를 선정하는데 성공한다.")
    @MethodSource("oneWinnerCarList")
    void getWinners_CarList_Success(List<Car> cars) {
        List<String> results = racingGame.getWinners(cars);
        assertThat(results).hasSize(3);
        assertThat(results).containsExactlyInAnyOrderElementsOf(List.of("가가", "나나", "다다"));
    }

    private static Stream<Arguments> oneWinnerCarList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("가가"), new Position(2)));
        cars.add(new Car(new Name("나나"), new Position(2)));
        cars.add(new Car(new Name("다다"), new Position(2)));
        return Stream.of(Arguments.of(cars));
    }
}
