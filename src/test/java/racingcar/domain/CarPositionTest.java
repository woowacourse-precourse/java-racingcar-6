package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarPositionTest {

    @DisplayName("자동차 포지션을 특정 size만큼 증가시킬 수 있다.")
    @ParameterizedTest
    @CsvSource(textBlock = """
            1, 1
            2, 2
            3, 3
            """)
    void increaseCarPosition_withSpecificSize(int size, int expectCurrentSize) {
        // given
        CarPosition carPosition = new CarPosition(0);

        // when
        carPosition.increase(size);

        // then
        assertThat(carPosition.getValue()).isEqualTo(expectCurrentSize);
    }


    @DisplayName("자동차의 현재 포지션이 일치하는지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(textBlock = """
            1, 1, true
            2, 3, false
            4, 10, false
            """)
    void possibleTo_checkCurrentPosition(int toIncreaseSize, int compareValue, boolean expectResult) {
        // given
        CarPosition carPosition = new CarPosition(0);

        // when
        carPosition.increase(toIncreaseSize);

        // then
        assertThat(carPosition.isSame(compareValue)).isEqualTo(expectResult);
    }
}