package racingcar.domain;

import org.junit.jupiter.api.Assertions;
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
        assertThatIllegalArgumentException().isThrownBy(() -> Car.createCar(inputName));
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
    @CsvSource(value = {"0, false",
            "1, false",
            "2, false",
            "3, false",
            "4, true",
            "5, true",
            "6, true",
            "7, true",
            "8, true",
            "9, true"})
    void 자동차_이동_테스트(int value, boolean expected) {
        Car car = Car.createCar("pobi");
        int initialPosition = car.getPosition();
        MovableStrategy movableStrategy = FixMoveStrategy.createStrategy(value);

        car.move(movableStrategy);

        if (expected) {
            Assertions.assertEquals(initialPosition + 1, car.getPosition());
        } else {
            Assertions.assertEquals(initialPosition, car.getPosition());
        }
    }

    @DisplayName("1등한 자동차인지 확인")
    @Test
    void 우승_테스트() {
        int targetPosition = 5;
        Car car = Car.createCar("Car");
        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> true);
        assertTrue(car.isWinner(targetPosition));
    }

    @DisplayName("1등한 자동차가 아닌지 확인")
    @Test
    void 우승_실패_테스트() {
        int targetPosition = 5;
        Car car = Car.createCar("Car");
        car.move(() -> true);
        car.move(() -> true);
        assertFalse(car.isWinner(targetPosition));
    }
}