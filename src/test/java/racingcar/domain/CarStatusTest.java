package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarStatusTest {

    private static Stream<Arguments> generateRandomNumber() {
        return Stream.of(
                Arguments.of(2, 0),
                Arguments.of(7, 1)
        );
    }
    private CarStatus testCarStatus;
    @BeforeEach
    void init() {
        testCarStatus = CarStatus.create("test");
    }

    @DisplayName("랜덤값이 4 이상이면 전진, 3 이하이면 정지한다")
    @ParameterizedTest(name = "[{index}] input : {0}")
    @MethodSource("generateRandomNumber")
    void carMoveForwardOrStop(int number, int result) {
        testCarStatus.forWard(number);

        assertThat(testCarStatus.getPosition()).isEqualTo(result);
    }

    @DisplayName("입력 객체의 위치와 현재 자동차 객체의 위치가 일치하면 true를 반환한다")
    @Test
    void isSamePositionReturnTrue() {
        CarStatus otherCar = CarStatus.create("other");
        assertThat(testCarStatus.isSamePosition(otherCar)).isEqualTo(true);
    }
    @DisplayName("입력 객체의 위치와 현재 자동차 객체의 위치가 일치하지 않으면 false를 반환한다")
    @Test void isSamePositionReturnFalse() {
        CarStatus otherCar = CarStatus.create("other");
        otherCar.forWard(8);

        assertThat(testCarStatus.isSamePosition(otherCar)).isEqualTo(false);
    }
}
