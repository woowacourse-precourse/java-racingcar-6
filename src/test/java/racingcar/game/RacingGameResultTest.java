package racingcar.game;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingGameResultTest {

    private OutputStream captor;

    @BeforeEach
    void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @ParameterizedTest
    @MethodSource("winnerProvider")
    void 최종_우승자를_조회한다(List<Car> cars, String expected) {
        // given
        RacingGameResult result = RacingGameResult.of(cars);

        // when
        String winner = result.getWinner();

        // then
        Assertions.assertThat(winner).isEqualTo(expected);
    }

    @Test
    void 최종_우승자를_출력한다() throws Exception {
        //given
        List<Car> cars = List.of(Car.of("foo1", "-----"),
                Car.of("foo2", "---"),
                Car.of("foo3", "--"));

        RacingGameResult result = RacingGameResult.of(cars);

        //when
        result.print();

        //then
        assertThat(output()).contains("최종 우승자 : foo1");
    }

    static Stream<Arguments> winnerProvider() {
        return Stream.of(
                Arguments.of(List.of(
                        Car.of("foo1", "-----"),
                        Car.of("foo2", "---"),
                        Car.of("foo3", "--")
                ), "foo1"),
                Arguments.of(List.of(
                        Car.of("foo1", "-----"),
                        Car.of("foo2", "-----"),
                        Car.of("foo3", "--")
                ), "foo1, foo2"),
                Arguments.of(List.of(
                        Car.of("foo1", "--"),
                        Car.of("foo2", "--"),
                        Car.of("foo3", "--")
                ), "foo1, foo2, foo3"),
                Arguments.of(List.of(),
                        ""),
                Arguments.of(List.of(
                        Car.of("foo1", "--"),
                        Car.of("foo2", "--"),
                        Car.of("foo3", "--")
                ), "foo1, foo2, foo3"),
                Arguments.of(List.of(
                        Car.of("foo1", ""),
                        Car.of("foo2", ""),
                        Car.of("foo3", "")
                ), "foo1, foo2, foo3")
        );
    }

    private String output() {
        return captor.toString().trim();
    }
}

