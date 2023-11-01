package racingcar.domain.raingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @DisplayName("자동차 이름을 다섯글자 초과하여 입력한 경우 IllegalArgumentException 발생")
    @Test
    void carNameMaxSizeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar("abcdef");
        });
    }

    @DisplayName("자동차 이름 공백일 경우 IllegalArgumentException 발생")
    @Test
    void carNameMinSizeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar("");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다", "!@#", "가ab", "!ab"})
    @DisplayName("자동차 이름이 영어가 아닌 경우 IllegalArgumentException 발생")
    void carNameEnglishTest(String value) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar(value);
        });
    }

    @DisplayName("자동차 앞으로 전진 1 이동 테스트")
    @Test
    void moveForward() {
        // Arrange
        RacingCar car = new RacingCar("pobi");

        // Act
        car.moveForward();

        // Assert
        Assertions.assertEquals(1, car.getPosition());
    }
}