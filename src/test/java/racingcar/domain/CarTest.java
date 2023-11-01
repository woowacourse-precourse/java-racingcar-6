package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car testCar;

    @BeforeEach
    void init() {
        testCar = new Car("pobi");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 7})
    @DisplayName("랜덤값이 4 이상일 경우 자동차가 전진한다.")
    void givenGreaterEqualThanFour_thenCarMove(final int randomNumber) {

        // given
        int beforeMove = testCar.getPosition();

        // when
        testCar.moveOrStop(randomNumber);

        // then
        assertThat(testCar.getPosition())
                .isEqualTo(beforeMove + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("랜덤값이 3 이하일 경우 자동차가 정지한다.")
    void givenLowerEqualThanThree_thenCarStop(int randomNumber) {

        // given
        int beforePosition = testCar.getPosition();

        // when
        testCar.moveOrStop(randomNumber);

        // then
        assertThat(testCar.getPosition())
                .isEqualTo(beforePosition);
    }
}