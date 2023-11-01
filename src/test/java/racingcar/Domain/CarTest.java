package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private Car testCar;

    @BeforeEach
    void init() {
        testCar = Car.create("pobi");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("랜덤값이 4 이상이면 전진")
    void givenFourMoreNumber_thenCarMove(final int randomNumber) {
        // given
        int initPosition = testCar.getPosition();

        // when
        testCar.CarMove(randomNumber);

        // then
        assertThat(testCar.getPosition())
                .isEqualTo(initPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("랜덤값이 3 이하면 정지")
    void givenThreeLessNumber_thenCarStop(final int randomNumber) {
        // given
        int initPosition = testCar.getPosition();

        // when
        testCar.CarMove(randomNumber);

        // then
        assertThat(testCar.getPosition())
                .isEqualTo(initPosition);
    }
}