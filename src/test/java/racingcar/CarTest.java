package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    @ParameterizedTest
    @MethodSource("전진_테스트를_위한_매개변수")
    void 전진_테스트(String carName, String carToString, int movePower) {
        Car car = new Car(carName);
        car.tryMove(movePower);
        assertThat(car.toString())
                .isEqualTo(carToString);
    }

    static Stream<Arguments> 전진_테스트를_위한_매개변수() {
        return Stream.of(
                Arguments.of("test", "test : -", 4),
                Arguments.of("test", "test : ", 3),
                Arguments.of("test", "test : -", 9),
                Arguments.of("test", "test : ", 1)
        );
    }
}