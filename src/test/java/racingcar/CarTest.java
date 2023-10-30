package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {

    private static final int MOVE = 1;
    private static final int STOP = 0;

    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("DY");
    }

    @ParameterizedTest
    @MethodSource("provideMoveRandomNumber")
    @DisplayName("자동차 전진")
    void 자동차_전진(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveForward();
                    assertThat(car.getDistance()).isEqualTo(MOVE);
                }, randomNumber
        );
    }

    @ParameterizedTest
    @MethodSource("provideStopRandomNumber")
    @DisplayName("자동차 정지")
    void 자동차_정지(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveForward();
                    assertThat(car.getDistance()).isEqualTo(STOP);
                }, randomNumber
        );
    }

    static Stream<Arguments> provideMoveRandomNumber() {
        return IntStream.rangeClosed(4, 9)
                .mapToObj(Arguments::of);
    }

    static Stream<Arguments> provideStopRandomNumber() {
        return IntStream.rangeClosed(0, 3)
                .mapToObj(Arguments::of);
    }
}
