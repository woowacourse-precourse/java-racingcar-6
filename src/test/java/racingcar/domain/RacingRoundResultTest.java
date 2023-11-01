package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingRoundResultTest {

    @DisplayName("getCars()를 통해 얻어낸 읽기전용 리스트를 조작하려고 하면 에러가 발생한다.")
    @Test
    void getCarsManipulateFailTest() {
        RacingRoundResult racingRoundResult = RacingRoundResult.getRacingRoundResult(
                List.of(setCar("pobi", 3), setCar("woni", 3)));
        List<Car> cars = racingRoundResult.getCars();
        assertThatCode(() -> cars.add(new Car(new CarName("jun"), new FixedCarEngine(true), new Position(3))))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatCode(() -> cars.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatCode(() -> cars.clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("getCars()를 통해 얻어낸 읽기전용 리스트를 읽기만 하는 것은 에러를 발생시키지 않는다.")
    @Test
    void getCarsManipulateSuccessTest() {
        RacingRoundResult racingRoundResult = RacingRoundResult.getRacingRoundResult(
                List.of(setCar("pobi", 3), setCar("woni", 3)));
        List<Car> cars = racingRoundResult.getCars();
        assertThatCode(() -> cars.get(0))
                .doesNotThrowAnyException();
    }

    @DisplayName("라운드의 승자를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideGetWinnerTestArguments")
    void getWinnersTest(List<Car> cars, List<String> expectedWinnerName) {
        RacingRoundResult racingRoundResult = RacingRoundResult.getRacingRoundResult(cars);
        List<String> winner = racingRoundResult.getWinners();
        assertThat(winner).isEqualTo(expectedWinnerName);
    }

    static Stream<Arguments> provideGetWinnerTestArguments() {
        return Stream.of(
                arguments(List.of(
                        setCar("pobi", 3),
                        setCar("woni", 2),
                        setCar("jun", 1)
                ), List.of("pobi")),
                arguments(List.of(
                        setCar("pobi", 3),
                        setCar("woni", 3),
                        setCar("jun", 1)
                ), List.of("pobi", "woni")),
                arguments(List.of(
                        setCar("pobi", 1),
                        setCar("woni", 2),
                        setCar("jun", 2)
                ), List.of("woni", "jun")),
                arguments(List.of(
                        setCar("pobi", 0),
                        setCar("woni", 0),
                        setCar("jun", 0)
                ), List.of("pobi", "woni", "jun"))
        );
    }

    private static Car setCar(String carName, int position) {
        return new Car(new CarName(carName), new FixedCarEngine(true), new Position(position));
    }
}
