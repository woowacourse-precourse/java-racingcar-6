package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @ParameterizedTest
    @DisplayName(value = "4 이상일 때만 isMoveForward 가 true 나오는지 확인")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void isMoveForwardTest(int randomNumber) {
        RacingCar racingCar = new RacingCar("TEST");

        if (randomNumber >= 4) {
            assertThat(racingCar.isMoveForward(randomNumber)).isTrue();
        } else {
            assertThat(racingCar.isMoveForward(randomNumber)).isFalse();
        }
    }

    @Test
    @DisplayName(value = "isMoveForward 가 true 일 때, RacingCar 의 location 이 제대로 전진하는지 확인")
    void moveForwardTest() {
        RacingCar racingCar = new RacingCar("TEST");

        for (int i = 0; i <= 9; i++) {
            if (racingCar.isMoveForward(i)) {
                racingCar.moveForward();
            }
        }

        assertThat(racingCar.getLocation()).isEqualTo("------");
    }

}