package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @DisplayName("자동차의 이름이 빈 값으로 입력하거나, 공백인 경우거나, NULL인 경우: IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @MethodSource("nameInputTestSource")
    void 자동차_생성_테스트(String inputName) {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.from(inputName));
    }

    private static Stream<Arguments> nameInputTestSource() {
        return Stream.of(
                Arguments.of(null),
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("  "),
                Arguments.of("다섯글자가되는지체크")
        );
    }

    @DisplayName("자동차의 랜덤 수가 4 이상일 경우 한 칸 이동한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 0",
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "6, 1",
            "7, 1",
            "8, 1",
            "9, 1"})
    void 자동차_이동_테스트(int value, int expectedPosition) {
        Car car = Car.from("pobi");
        MovableStrategy movableStrategy = FixMoveStrategy.from(value);
        car.move(movableStrategy);

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("")
    @Test
    void _테스트() {
        int targetTopPosition = 5;
        Car car = Car.from("Car");
        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> true);
        assertTrue(car.isTopPosition(targetTopPosition));
    }

    @DisplayName("1등한 자동차가 아닌지 확인")
    @Test
    void 우승_실패_테스트() {
        int targetPosition = 5;
        Car car = Car.from("Car");
        car.move(() -> true);
        car.move(() -> true);
        assertFalse(car.isTopPosition(targetPosition));
    }
}