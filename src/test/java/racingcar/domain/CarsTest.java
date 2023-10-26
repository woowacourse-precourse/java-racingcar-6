package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.CarException.DUPLICATE_CAR;
import static racingcar.exception.ExceptionMessage.CarException.NO_PARTICIPANTS;

public class CarsTest {
    @Test
    @DisplayName("경주에 참여하는 자동차가 비어있으면 게임을 진행할 수 없다")
    void throwExceptionByNoParticipants() {
        assertThatThrownBy(() -> Cars.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NO_PARTICIPANTS.message);
    }

    @Test
    @DisplayName("중복된 자동차가 존재하면 게임을 진행할 수 없다")
    void throwExceptionByDuplicateCar() {
        // given
        final List<Car> candidate = List.of(
                new Car("pobi"),
                new Car("pobi"),
                new Car("pobi2")
        );

        // when - then
        assertThatThrownBy(() -> Cars.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR.message);
    }

    @Test
    @DisplayName("게임에 참여할 Cars를 관리한다")
    void success() {
        // given
        final List<Car> candidates = List.of(
                new Car("pobi1"),
                new Car("pobi2"),
                new Car("pobi3")
        );

        // when
        final Cars cars = Cars.from(candidates);

        // then
        assertThat(cars.getCars()).hasSize(candidates.size());
    }

    @ParameterizedTest(name = "[{index}] 경주 참여자 = {0} -> 우승자 -> {1}")
    @MethodSource("winners")
    @DisplayName("자동차 경주 게임 우승자를 조회한다")
    void getWinners(
            final List<Car> participants,
            final List<Car> expected
    ) {
        // given
        final Cars cars = Cars.from(participants);

        // when
        final List<Car> winners = cars.getWinners();

        // then
        assertThat(winners).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> winners() {
        final Car car1 = generateCar("pobi1", 3);
        final Car car2 = generateCar("pobi2", 4);
        final Car car3 = generateCar("pobi3", 4);
        final Car car4 = generateCar("pobi4", 5);
        final Car car5 = generateCar("pobi5", 5);

        return Stream.of(
                Arguments.arguments(List.of(car1, car2), List.of(car2)),
                Arguments.arguments(List.of(car1, car2, car3), List.of(car2, car3)),
                Arguments.arguments(List.of(car1, car2, car3, car4), List.of(car4)),
                Arguments.arguments(List.of(car1, car2, car3, car4, car5), List.of(car4, car5))
        );
    }

    private static Car generateCar(final String name, final int moveCount) {
        final Car car = new Car(name);
        for (int i = 0; i < moveCount; i++) {
            car.moveForward(5);
        }
        return car;
    }
}
